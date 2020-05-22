public class MySuperClass {
    protected void method() {
         // Whatever you want to do in super class
    }
}

public class MyClass extends MySuperClass {
    @Override
    protected void method() {
         // Whatever you want to do in this specific class

         // Call super.method
         super.method();
    }
}