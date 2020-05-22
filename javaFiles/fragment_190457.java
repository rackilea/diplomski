@Test
public void multimapAcceptsMultipleEqualValuesForOneKey() {
    ListMultimap<String, String> listMultimap = ArrayListMultimap.create();
    listMultimap.put("aha", "eh");
    listMultimap.put("aha", "eh");
    Assert.assertEquals(2, listMultimap.get("aha").size());
}