@Test(dataProvider = "<nameYourData>")
public void yourMethod(<Data returned from dataProvider>) {
....// do whatever you want to test (in your case the method stated)
}

@DataProvider
public Object[][] getData()
{
  //Rows - Number of times your test has to be repeated.
  //Columns - Number of parameters in test data.
  Object[][] data = new Object[3][2];
  // 1st row
  data[0][0] ="sampleuser1";
  // 2nd row
  data[1][0] ="testuser2";
  return data;
}