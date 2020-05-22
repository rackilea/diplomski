@RunWith(Parameterized.class)
public class ATest {
    private A theClass;

    public ATest(A theClass) {
        this.theClass= theClass;
    }

    @Test
    public final void doSomething() {
        // make assertions on theClass.doSomething(theClass)
    }


    @Parameterized.Parameters
    public static Collection<Object[]> instancesToTest() {
        return Arrays.asList(
                    new Object[]{new B()},
                    new Object[]{new C()}
        );
    }
}