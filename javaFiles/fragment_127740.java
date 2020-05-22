@Test
public void getAllItems() {

    Collection<Item> actualItems = auction.getAllItems(joe);
    Collection<Item> expectedItems = Lists.newArrayList();

    // First add both items
    expectedItems.add(iPhone);
    expectedItems.add(skateboard);

    // Then print both lists
    System.out.println(expectedItems);
    System.out.println(items);

    assertThat(expectedItems, contains(actualItems));
}