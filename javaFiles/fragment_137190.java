import java.lang.reflect.ParameterizedType;

public static Class<?> getDomainClass(final Class<?> daoInterface) {
    ParameterizedType type = (ParameterizedType) daoInterface.getGenericInterfaces()[0];
    return (Class<?>) type.getActualTypeArguments()[0];
}