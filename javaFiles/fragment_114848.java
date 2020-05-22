@RunWith(OrderedRunner.class)
public class OrderOfTest {
    @Test public void testA() { System.out.println("A"); }
    @Test public void testC() { System.out.println("C"); }
    @Test public void testB() { System.out.println("B"); }
}