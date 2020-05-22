super(new ClickHandler() {

    // This is anonymous class body 
    // You cannot place code directly here. Embed it in anonymous block, 
    // or a method.

    try {
        OtherClass.responseMethod(
            MyClass.class.getMethod("myMethod",boolean.class));
    } catch (Exception e) {
        e.printStackTrace();
    }
});