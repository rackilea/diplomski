public interface Root {
    class Enclosed {}
} 

public static class LeafImplementingRoot implements Root {}        


@Test
public void testInheritanceImplements() {
    Class<?> enclosing  = LeafImplementingRoot.class;
    Class<?>[] enclosed = enclosing.getClasses();
    System.out.println(Arrays.deepToString(enclosed));
    Assert.assertNotEquals(0, enclosed.length);
}