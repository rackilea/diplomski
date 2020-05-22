@DataProvider(name="userData")
 public Object[][] sampleDataProvider()
 {
  Object[][] data = {
    {"loginTestUS_Username","loginTestUSPass"}, 
    {"loginTestIN_Username","loginTestINPass"},
    {"loginTestJP_UserName","loginTestJPPass"}
  };

  return data;
 }



 @SetTestName(idx=0)
 @Test(dataProvider="userData")
 public void test1(String userName, String pass)
 {
     System.out.println("Testcase 1");
 }

 @SetTestName(idx=1)
 @Test(dataProvider="userData")
 public void test2(String userName, String pass)
 {
     System.out.println("Testcase 2");
 }