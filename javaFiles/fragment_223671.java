@ContextConfiguration(locations={"classpath:I_DONT_EXIST.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class Test2 {
    public static void main(String [] args){
        System.out.println("Hello World");
    }

    @Test
    public void testSomething() {
    }
}