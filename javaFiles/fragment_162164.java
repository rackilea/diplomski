public String factorial(String base) throws ClientErrorException {
    WebTarget resource = webTarget;
    if (base != null) {
        resource = resource.queryParam("base", base);
    }
    return resource.request().get(String.class);  // <-- changed
}