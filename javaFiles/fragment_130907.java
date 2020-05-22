interface SomeInterface<T extends SuperRequest, U extends SuperResponse> {
    public U someMethod(T request);
}

class SomeImplementation implements SomeInterface<SubRequest, SubResponse> {

    @Override
    public SubResponse someMethod(SubRequest request) {
        return null;
    }
}