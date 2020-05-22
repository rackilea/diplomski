class MyGwtObject {
    private String valueA;
    private String valueB;
    public MyGwtObject(MyObj obj) {
        this.valueA = obj.getValueA();
        this.valueB = obj.getValueB();
    }
}