Object[][] data = { { "hello", "world" }, { "bye", "world" } };
//convert Object[][] to List<Object[]>
List<Object[]> dlist = new ArrayList<>(Arrays.asList(data) );
for (Object[] o : dlist) {
    System.out.println(Arrays.deepToString(o));
}
//convert List<Object[]> to Object[][]
Object[][] data2 = dlist.toArray(new Object[0][]);
System.out.println(Arrays.deepToString(data2));