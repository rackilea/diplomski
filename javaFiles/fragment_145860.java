interface SomeType {
}

class Impl1 implements SomeType {
}

interface SomeInterface<T extends SomeType> {
    T convert(String param);
    String convert(T param);
}

class SomeInterfaceImpl implements SomeInterface<Impl1> {
    @Override
    public Impl1 convert(String param) {
        return null;
    }

    @Override
    public String convert(Impl1 param) {
        return null;
    }
}