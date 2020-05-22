static class MyList extends ArrayList<MyInterface> {
    @Deprecated
    public boolean add(MyInterface obj) {
        assert obj instanceof MyClass;
        return super.add(obj);
    }

    public <T extends MyClass & MyInterface> boolean add(T obj) {
        return super.add(obj);
    }
}