import net.jodah.typetools.TypeResolver;

public GenericDaoImpl <T> {

    private Class<T> type;

    public GenericDaoImpl () { 
         Class<?>[] typeArguments = TypeResolver.resolveRawArguments(GenericDaoImpl.class, getClass());
         this.type = (Class<T>) typeArguments[0];
    }

    public T findById(Serializable id) {
        return (T) HibernateUtil.findById(type, id);
    }
}