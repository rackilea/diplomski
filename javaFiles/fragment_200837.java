@Test
public void testAsList() {

    List<Object> listO = Arrays.asList(new Object[] { null });
    System.out.println(listO.size());
    System.out.println(listO.get(0) == null);

    List<Type> listT = Arrays.asList(new Type[] { null });
    System.out.println(listT.size());
    System.out.println(listT.get(0) == null);
}