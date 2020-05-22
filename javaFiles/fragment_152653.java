enum MyEnum {
    FOO {
        public void foo() {}
    };
}

public class Test {
    public static void main(String[] args) throws Exception
    {
        MyEnum.FOO.foo(); // Error
    }
}