class MyClass {
    public void myMethod() {
        System.out.println("Hello Java Reflection!!!");
    }
}

Method theMethod = MyClass.class.getDeclaredMethod("myMethod");
System.out.println(theMethod);
theMethod.setAccessible(true);
theMethod.invoke(null);