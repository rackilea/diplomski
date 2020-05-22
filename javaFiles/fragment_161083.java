public class MyTest {

  @Mock
  private ArrayList<String> mockArrayList;

  ...

  public void setUp() {
    MockitoAnnotations.initMocks(this);
  }

  public void testMyTest() {
    when(mockArrayList.get(0)).thenReturn("Hello world");

    String result = mockArrayList.get(0);

    assertEquals("Should have the correct string", "Hello world", result);

    verify(mockArrayList).get(0);
  }
}