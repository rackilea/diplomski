@DataProvider(parallel = true)
public Object[][] listToArrays() {
    List<String> list = new ArrayList();
    list.add("1");
    list.add("2");
    list.add("3");
    list.add("4");
    Object[][] array = new Object[list.size()][1];
    for (int i = 0; i < list.size(); i++) {
        array[i][0] = list.get(i);
    }
    return array;
}

@Test(dataProvider = "listToArrays")
public void test(String s) {
    System.out.println(s + " " + Thread.currentThread().getId());
    //do your test with s
}