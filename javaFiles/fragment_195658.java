public class ApplicationErrorHandlerTest {

        @Test
        public void BadRequestExceptionTest() throws Exception  {
            BadRequestException badRequestException1 = new BadRequestException();
            Strign testMessage = "testMessage";
            BadRequestException badRequestException2 = new BadRequestExceptiontestMessage);
            assertNotNull(badRequestException1);
            assertNotNull(badRequestException2);
            assertEquals(testMessage, badRequestException2.getMessage());
        }
   }