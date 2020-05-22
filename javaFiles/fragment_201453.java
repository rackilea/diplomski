public class MockHelper {

@Mocked
ClassB classB;

public void setupMocks() {

    new MockUp<ClassA>() {

        @Mock
        public void methodA() {
            System.out.println("In setupMocks, classB:" + classB);
        }
    };
}
}