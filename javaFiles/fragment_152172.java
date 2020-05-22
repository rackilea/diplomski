//This method will provide data to any test method that declares
//that its Data Provider is named "test1"
@DataProvider(name = "test1")
public Object[][] createData1() {
   return new Object[][] {
     new Object[] { "Parameter" }
   }
}

//This test method declares that its data should be supplied 
//by the Data Providernamed "test1"
@Test(dataProvider = "test1")
public void Courier_Test(String parameter) {
 System.out.println(parameter);
}