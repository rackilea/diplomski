package test;

@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class Test {

    private @Autowired List<TypeA> beans;

    @org.junit.Test
    public void test() {
        assertNotNull(beans);
        assertEquals(2, beans.size());
        for (TypeA bean : beans) {
            assertTrue(bean instanceof TypeA);
        }
    }       

    public static interface TypeA {}
    public static class TypeB implements TypeA {}
    public static class TypeC extends TypeB {}
    public static class TypeD {}

}