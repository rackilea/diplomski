@RunWith(MockitoJUnitRunner.class)
public class MyClassTest {

            @Mock
            MyService myService;

            @InjectMocks
            MyClass testObjMyClass;

            @Before
            public void setup() {
                MockitoAnnotations.initMocks(this);
                when(myService.isAnimal(dog.getStatus())).thenReturn(true);
            }

            @Test
            public void testMyMethod() {

                Dog dog = new Dog();
                dog.setStatus("Y"); // this should give true for isAnimal()

                testObjMyClass.myMethod(dog, animal);// I defined animal in test Class variables before.
                assertEquals("mike", dog.getName());
            }

        }