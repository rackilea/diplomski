@RunWith(PowerMockRunner.class)
 @PrepareForTest({MyClass.class, LearnerFactory.class})
 public class MyClassTest {

     @Test
     public void test2() throws Exception {             
         StaticLearner mockLearner = 
             PowerMockito.mock(StaticLearner.class);
         //if needed
         when(mockLearner.doSomething(anyString()))
             .thenReturn("dummy");

         PowerMockito.mockStatic(LearnerFactory.class);
         when(LearnerFactory.getInstance(eq(StaticLearner.class)))
            .thenReturn(mockLearner);

         MyClass myClass = new MyClass(true, StaticLearner.class);
         myClass.process();
     }

 }