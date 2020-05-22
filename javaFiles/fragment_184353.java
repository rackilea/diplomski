class MyResource implements AutoCloseable {

    public SubResource getSubResource() {
        return new SubResource();
    }

    @Override
    public void close() throws Exception {
        System.out.println("Resource closed");
    }
}