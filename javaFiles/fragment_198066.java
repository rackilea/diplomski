try {
    // you need to use the fully qualified name, not just the class name
    SomeObject object = (SomeObject) Class.forName("com.mypackage.SomeObject").newInstance();
} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
    // here you can handle incorrect config in your XML file
}