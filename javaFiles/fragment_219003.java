public interface Converter<T, U> extends Serializable {
    U from(T databaseObject);
    T to(U userObject);
    Class<T> fromType();
    Class<U> toType();
}