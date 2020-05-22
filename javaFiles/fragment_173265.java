@Test
public void testStatic() {
    new Expectations(Provider.class) {{ Provider.getStaticList(); result = 1; }};

    List<Integer> test = Provider.test();

    assertTrue(test.contains(1));
}