@RunWith(MockitoJUnitRunner.class)
public class DemoApplicationTests {
    private ClassA classA;
    private ClassB classB;

    @Test
    public void testInitClient() {
        classA = Mockito.spy(ClassA.class);
        classB = Mockito.spy(new ClassB("a", "b"));

        Mockito.doNothing()
                .when(classB)
                .meth1();

        // This will replace the ClassA#generateClassB method call with the setter
        Mockito.doAnswer(args -> {
            classA.setClassB(classB);
            return null;
        }).when(classA).generateClassB(Mockito.any(), Mockito.any());
        classA.initMethod("a", "b", "c", "d");
    }
}