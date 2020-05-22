public static class NestedClass {
    XYZ x;
    void someMethod() { 
       x.instanceMethod();  // legal even if instanceMethod is non-static
    }
}