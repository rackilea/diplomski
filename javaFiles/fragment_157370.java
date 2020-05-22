@RunWith(MockitoJUnitRunner.class)
public class TestClass {
   @Mock
   ConsoleReaderWriter crw;

   @InjectMocks
   UnderTestClass underTest;

   //Some other fields

   @Test
   public void testReadPlayerNameShouldReturnNameString() {
      String testName = "John Doe";

      when(crw.readLine()).thenReturn("John Doe");

      assertEquals(testName, underTest.readPlayerName());
   }
}