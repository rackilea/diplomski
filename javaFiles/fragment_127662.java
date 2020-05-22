if(Page.class.isAssignableFrom(proxy) { //true if proxy is Page or subclass of Page
    obj = getPage(proxy);
}
else if(Number.class.isAssignableFrom(proxy) {
    obj = doSomeMaths(proxy);
}