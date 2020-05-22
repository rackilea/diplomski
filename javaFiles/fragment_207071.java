class MyWUPojo {
    public Response response;
    // more after this that match the JSON
}

class Response {
    public String version;
    public String termsofservice;
    public Map<String, Integer> features;
}