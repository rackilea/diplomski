Persister serializer = new Persister(new Matcher() {
    public Transform match(Class type) throws Exception {
        if (type.isEnum()) {
            return new MyEnumTransform(type);
        }
        return null;
    }
 });