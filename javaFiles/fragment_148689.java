public void close(Object resource) throws Exception {
    if(resource!=null){
        Method m = resource.getClass().getMethod("close");
        m.invoke(resource);
    }
}