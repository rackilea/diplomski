@Test(dataProvider = "pojoProvider")
public void getData(DataObject dataObj)throws Exception 
{
    System.out.println(dataObj.getUserName()+ "\t ****");
    System.out.println(dataObj.getPasswrod());
}