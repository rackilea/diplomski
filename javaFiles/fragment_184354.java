class SubResource implements AutoCloseable{
    @Override
    public void close() throws Exception {
        System.out.println("SubResource closed");
    }
}