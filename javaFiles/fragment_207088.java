class Object1 {
    private Object2 object2 = new Object2();

    /* Setter Method for Object2 */
    public void setObject2(Object2 object2) {
         this.object2 = object2;
    }

    public void method1() {
        String info = object2.getInfo();
        // ...
        // working with info, which I want to test
        // ...
    }
}