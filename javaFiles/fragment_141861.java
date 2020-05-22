// Java code
public class TestTypes {
    public void method1(Foo param1) {}

    public Object getObject() { new Foo() }
}

// Python code
myJavaObject = java_gateway.jvm.TestTypes()
obj = myJavaObject.getObject()
// no need for type casting
myJavaObject.method1(obj)