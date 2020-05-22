public class DemoTestClass {
@Test(dataProvider = "getData")
public void   testSheetA(String username, String pass){
....}

@Test(dataProvider = "getData")
public void
    testSheetB(String username, String pass){...}

@Test(dataProvider = "getData")
public void
    testSheetC(String username, String pass){....}

}