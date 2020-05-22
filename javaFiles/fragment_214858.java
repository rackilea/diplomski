public class MyClass {
   private Apple apple;

   public void myMethod() {
       apple = createApple();
       ....
       ....
       ....
   }

   protected Apple createApple() {
       return AppleFactory.createInstance(someStringVariable);
   }
}


@RunWith(MockitoJUnitRunner.class)
public class MyClassTest {

    @Mock
    private Apple appleMock;

    @InjectMocks 
    MyClass myClass;

    @Test
    public void myMethod(){
     ...
     ...
     ...
    }

    private class TestableMyClass extends MyClass {
       @Override
       public void createApple() {
          return appleMock;
       }
    }
}