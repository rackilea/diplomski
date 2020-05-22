public interface Root {
    class Enclosed {}
}

public interface Leaf extends Root {}

@Test
public void testInheritanceInterfaces() {
     Class<?> enclosing  = Leaf.class;
     Class<?>[] enclosed = enclosing.getClasses();
     System.out.println(Arrays.deepToString(enclosed));
     Assert.assertNotEquals(0, enclosed.length);
}