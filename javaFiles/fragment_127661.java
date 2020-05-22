protected <T> List<T> click(String buttonDescription, WebElement button, List<Class<? extends T>> proxies) {
    click(buttonDescription, button);
    List<T> retObjs = new ArrayList<>();
    for(Class<? extends T> proxy : proxies) {
        T obj = getPage(proxy);
        if(obj!=null)
            retObjs.add(obj);
    }
    return retObjs;
}