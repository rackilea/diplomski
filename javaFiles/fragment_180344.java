public void fetchData() {
    MyClass mydatas = new MyClass();
    try {
        List<MyType> thedatas = mydatas.getAllData();
    } catch (Exception ex) {
        // display or log exception name
    }
}