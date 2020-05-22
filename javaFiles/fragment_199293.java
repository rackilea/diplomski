protected ResponseObject postJson(String url, Animal object) throws IOException {
    return post(url, getString(object, object.getClass() /* Cat.class */));
}

private String getString(Animal object, Class<Animal> clazz) {
    // some code that relies on object being of type clazz
}