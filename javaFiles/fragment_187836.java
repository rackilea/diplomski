public static class RootClass {
      public static class Enclosed {}
}

public static class LeafClass extends RootClass {}

@Test
public void testInheritanceClasses() {
    Class<?> enclosing  = LeafClass.class;
    Class<?>[] enclosed = enclosing.getClasses();
    System.out.println(Arrays.deepToString(enclosed));
    Assert.assertNotEquals(0, enclosed.length);
}