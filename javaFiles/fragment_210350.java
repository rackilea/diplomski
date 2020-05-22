@Test
public void addItem_given_item_not_present_then_getAll_retrieves_it() {
   basket.addItem(new Item("foo"));
   Map<Item, Integer> items = basket.getAll();
   // assert items contains 1 element with 1 occurrence and with the foo name
}