Collections.sort(itemList, new Comparator<Item>() {

   @Override
   public int compare(Item o1, Item o2) {
      return o1.getManufacturer().compareTo(o2);
   }
});