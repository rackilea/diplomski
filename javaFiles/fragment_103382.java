public class YourNewAbstractClass<T extends BaseInterface> extends LegacyAbstractClass {
    @Override
    public void do(Data someData, BaseInterface interface) {
        // getting the generic parameter that you will define in a subclass
        Class<T> clazz = (Class<T>) ((ParameterizedType) getClass()
                        .getGenericSuperclass()).getActualTypeArguments()[0];
        // dynamically casting your object to a generic type
        T casted = clazz.cast(something);
        doCasted(someData, casted);
    }

    public abstract doCasted(Data someData, T casted)
}