map.put("someString", new Task() {
    @Override
    public void doSomething() {
        System.out.println("foo");
    }
});
map.put("someOtherString", new Task() {
    @Override
    public void doSomething() {
        System.out.println("bar");
    }
});