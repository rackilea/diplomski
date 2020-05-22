package mypackage;

import static mypackage.Test.MyEnum.*;

public class Test
{
    enum MyEnum{E1, E2};

    public static void aTestMethod() {
        Test2(E1);  
    }

    public static void Test2(MyEnum e) {}
}