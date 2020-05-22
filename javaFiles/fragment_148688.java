@Test
public void testRes() throws Exception {
    try(ClosableWrapper<StringWriter> rs = new ClosableWrapper<>(new StringWriter())){
        Writer wr = rs.getResource();
    }
}
static class ClosableWrapper<T> implements AutoCloseable{
    private T resource;
    private String closeMethod = "close";

    public ClosableWrapper(T resource) {
        this.resource = resource;
    }

    public ClosableWrapper(T resource, String closeMethod) {
        this.resource = resource;
        this.closeMethod = closeMethod;
    }

    public T getResource() {
        return resource;
    }

    @Override
    public void close() throws Exception {
        if(resource!=null){
            Method m = resource.getClass().getMethod(closeMethod);
            m.invoke(resource);
        }
    }
}