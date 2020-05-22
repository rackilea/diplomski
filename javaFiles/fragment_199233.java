public String callFromJs(final String url, final String method){

return AccessController.doPrivileged(new PriviledgetAction<String>(){
    public String run(){
        return getUrl(url, method);
    }
});
}