import java.lang.reflect.*;

static <E> Class<E> getClassE(List<E> list) {
    Class<?> listClass = list.getClass();

    Type gSuper = listClass.getGenericSuperclass();
    if(!(gSuper instanceof ParameterizedType))
        throw new IllegalArgumentException();

    ParameterizedType pType = (ParameterizedType)gSuper;

    Type tArg = pType.getActualTypeArguments()[0];
    if(!(tArg instanceof Class<?>))
        throw new IllegalArgumentException();

    @SuppressWarnings("unchecked")
    final Class<E> classE = (Class<E>)tArg;
    return classE;
}