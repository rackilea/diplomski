public abstract class MyInterfacecontractTestSuite {

    @Test(dataProvider="someDataProvider")
    public void testContract(String arg) {
        //test against getMi()
    }

    public abstract MyInterface getMi();
}

public class MyInterface1ImplTest extends MyInterfacecontractTestSuite {

    private MyInterface1Impl mi; // init somewhere

    public MyInterface getMi() {
        return mi;
    }

    //test cases for the implementation MyInterface1Impl
}