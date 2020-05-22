@RunWith(JMockit.class)
public class SomeTest {
    @Tested
    private System1 system;

    @Injectable
    private ClassA memberA;

    @Test
    public void doSystemTest() {
        // Do stuff
        system.handle();

        new Verifications() {
            {
                memberA.doSomeAStuff(); times = 1;
            }
        };
    }
}