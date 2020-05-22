@Test
public void testClass() throws Exception
{
    ResultSet rsResult = Mockito.mock(ResultSet.class);

    when(clsTableClass.getRecords(
            (Integer) any(),
            (String) any()).thenReturn(rsResult);
}