public class MyClassTest {

@Test
public void testM() {

    MyClass myClass = new MyClass();

    DAO mockDAO = mock(DAO.class);
    Data mockData = mock(Data.class);

    when(mockDAO.loadData()).thenReturn(mockData);
    myClass.setDao(mockDAO);

    // Call method under test
    myClass.m();

    // Rest of test ...
}