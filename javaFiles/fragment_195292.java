public static final Map<Double, Field> tmp = new HashMap<Double, Field>();
    private static Field getField(Class root, Class clazz, String name) throws PropertyNotFoundException {
        if ( clazz==null || clazz==Object.class ) {
            throw new PropertyNotFoundException("field [" + name + "] not found on " + root.getName()); 
        }               
        double hash = name.hashCode() + clazz.hashCode()*1.1;
        Field field = tmp.get( hash );
        if (field==null)
        try {
            field = clazz.getDeclaredField(name);
            tmp.put( hash, field );
        }
        catch (NoSuchFieldException nsfe) {
            field = getField( root, clazz.getSuperclass(), name );
        }
        field.setAccessible(true);
        return field;
    }