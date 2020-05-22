public enum MyEnum {

    VALUE1(String.class),
    VALUE2(Boolean.class);

    public final Class<?> type;
    MyEnum(Class<?> type){ this.type = type; }

    public <T> T get() {
        return (T) AnotherSystem.get(this, this.type);
    }

}

class AnotherSystem
{
    static<T> T get(MyEnum e, Class<T> type){ return null; }
}