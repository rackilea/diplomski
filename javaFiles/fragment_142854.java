@RunWith(MockitoJUnitRunner.class)
public class MyTest { 

   @Mock private PropertiesHolder holder;

   @Test
   public void testSomething() {
      SomeService service = new SomeService(holder);

      when(holder.getProperty("foo")).thenReturn("bar");

      String result = service.doSomething(); 

      assertEquals(...)
   }

}