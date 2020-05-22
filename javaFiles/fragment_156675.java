@SuppressWarnings({"serial","rawtypes"})
public class AliasToBeanResultTransformer implements ResultTransformer, Serializable {

    // IMPL NOTE : due to the delayed population of setters (setters cached
    //      for performance), we really cannot properly define equality for
    //      this transformer

    private final Class resultClass;
    private boolean isInitialized;
    private String[] aliases;

    private Setter[] setters;
    private Getter[] getters;

    public AliasToBeanResultTransformer(Class resultClass) {
        if ( resultClass == null ) {
            throw new IllegalArgumentException( "resultClass cannot be null" );
        }
        isInitialized = false;
        this.resultClass = resultClass;
    }

    @Override
    public Object transformTuple(Object[] tuple, String[] aliases) {
        Object result;

        try {
            if ( ! isInitialized ) {
                initialize( aliases );
            }
            else {
                check( aliases );
            }

            result = resultClass.newInstance();

            for ( int i = 0; i < aliases.length; i++ ) {
                Setter setter = setters[i];
                if ( setter != null ) {
                    Class paramType = setter.getMethod().getParameterTypes()[0];

                    if(paramType != null) {
                        Object obj = tuple[i];
                        // Check if parameter is a collection
                        if(!obj.getClass().equals(paramType) && isCollection(paramType)) {
                            insertToList(result, obj, getters[i], aliases[i]);
                        }
                        else {
                            setter.set( result, obj, null );
                        }
                    }
                }
            }
        }
        catch ( InstantiationException e ) {
            throw new HibernateException( "Could not instantiate resultclass: " + resultClass.getName() );
        }
        catch ( IllegalAccessException e ) {
            throw new HibernateException( "Could not instantiate resultclass: " + resultClass.getName() );
        }

        return result;
    }

    @Override
    public List transformList(List collection) {
        return collection;
    }

    @SuppressWarnings("unchecked")
    private boolean insertToList(Object result, Object obj, Getter getter, String alias) {
        Class genClass;
        try {
            genClass = ReflectUtils.getGenericType(resultClass.getDeclaredField(alias));

            // Check if the collection can take the obj
            if(genClass.equals(obj.getClass())) {
                Collection collection = (Collection) getter.get(result);
                collection.add(obj);
                return true;
            }
        } catch (NoSuchFieldException | SecurityException e) {}

        return false;
    }

    private void initialize(String[] aliases) {
        PropertyAccessor propertyAccessor = new ChainedPropertyAccessor(
                new PropertyAccessor[] {
                        PropertyAccessorFactory.getPropertyAccessor( resultClass, null ),
                        PropertyAccessorFactory.getPropertyAccessor( "field" )
                }
        );
        this.aliases = new String[ aliases.length ];
        setters = new Setter[ aliases.length ];
        getters = new Getter[ aliases.length ];
        for ( int i = 0; i < aliases.length; i++ ) {
            String alias = aliases[ i ];
            if ( alias != null ) {
                this.aliases[ i ] = alias;
                setters[ i ] = propertyAccessor.getSetter( resultClass, alias );
                getters[ i ] = propertyAccessor.getGetter( resultClass, alias );
            }
        }
        isInitialized = true;
    }

    private void check(String[] aliases) {
        if ( ! Arrays.equals( aliases, this.aliases ) ) {
            throw new IllegalStateException(
                    "aliases are different from what is cached; aliases=" + Arrays.asList( aliases ) +
                            " cached=" + Arrays.asList( this.aliases ) );
        }
    }

    private boolean isCollection(Class clazz) {
        return Collection.class.isAssignableFrom(clazz);
    }

    public boolean equals(Object o) {
        if ( this == o ) {
            return true;
        }
        if ( o == null || getClass() != o.getClass() ) {
            return false;
        }

        AliasToBeanResultTransformer that = ( AliasToBeanResultTransformer ) o;

        if ( ! resultClass.equals( that.resultClass ) ) {
            return false;
        }
        if ( ! Arrays.equals( aliases, that.aliases ) ) {
            return false;
        }

        return true;
    }

    public int hashCode() {
        int result = resultClass.hashCode();
        result = 31 * result + ( aliases != null ? Arrays.hashCode( aliases ) : 0 );
        return result;
    }
}