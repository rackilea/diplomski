public class Check_Test extends TestCase
{
    public void testMyCheck()
    {
        EmployeeFactory employeeFactoryMock = Mockito.mock(EmployeeFactory.class);
        Check checkObj = new Check(employeeFactoryMock);
        Mockito.doReturn(Collections.EMPTY_LIST).when(employeeFactoryMock).getEmployee();
        String str = checkObj.myCheck();
        assertEquals("", str);
    }
}