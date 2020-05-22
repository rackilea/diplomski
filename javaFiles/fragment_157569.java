class MyData extends RealmObject {
    private RealmList<MyMapEntry> myMap;
}

class MyMapEntry extends RealmObject {
    private String key;
    private MyClass value;
}