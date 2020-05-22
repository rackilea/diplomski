public List<Foo> getFoo() throws ServiceResponseException{
    List<Foo> foos = null;
    try {
        foos = fooCache.get(foo.getId(),
                () -> populateCacheWithFoo());
    } catch (ExecutionException e) {
        e.printStackTrace();
    } catch (UncheckedExecutionException e) {
        Throwables.propagateIfPossible(
        e.getCause(), ServiceResponseException.class);
    } 
    return foos;
}