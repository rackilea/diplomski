class MyMatcher implements AttributesMapper<Attributes> {

    List<MyObject> list = new ArrayList<>();

    public Attributes mapFromAttributes(Attributes attrs) {

        NamingEnumeration<?> enumeration = attrs.get(key).getAll();
        list.addAll(addToList(enumeration));
        return attrs;
    }
}