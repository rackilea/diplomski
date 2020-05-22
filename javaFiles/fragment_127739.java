@Test
public void getAllItems() {

    Collection<Item> actualItems = auction.getAllItems(joe);
    Collection<Item> expectedItems = Lists.newArrayList();

    // You first print both lists
    System.out.println(expectedItems);
    System.out.println(items);

    // And then add the two items to the expectedItems
    expectedItems.add(iPhone);
    expectedItems.add(skateboard);
    assertThat(expectedItems, contains(actualItems));
}