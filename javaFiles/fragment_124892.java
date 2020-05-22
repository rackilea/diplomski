public class SuperItem {
   List<Item> superItems = new LinkedList<Item>();
   List<Item> currentSubItems = null;


   public void addItem(Item s, boolean isNewSublist) {
      if (isNewSublist || currentSubItems == null) {
         currentSubItems = new LinkedList<Item>();
         superItems.add(currentSubItems);
      }
      if (!currentSubItems.contains(s))    {
         currentSubItems.add(s);
      }
      ...
   }

   public List<Item> getAllSubItems() {
      List<Item>subItems = new List<Item>();
      for (List<Item> superItem : superItems) {
         for (Item item : superItem.subItems) {
      ...
      return subItems;
   }
}