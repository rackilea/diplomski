Collections.sort(MyCollection, new Comparator<MyClass>() {
    @Override public int compare(MyClass c1, MyClass c2) {
        if(c1.Key < c2.Key) return -1;
        if(c1.Key > c2.Key) return 1;
        return 0;
    }
});