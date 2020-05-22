class MyClass {

    private Entity entity;

    public MyClass(Entity entity) {
      this.entity = entity;
    }

    void myMethod() {
        String str = entity.getField(); // It's null now
        if (str == null) { //always true
            //do something
        }
    }
}