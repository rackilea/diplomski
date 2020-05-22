public void add(Measurable newItem) {
   list.add(newItem);

   if (min == null || newItem.compareTo(min) < 0) {
      min = newItem;
   }
   if (newItem.compareTo(max) > 0) {
      max = newItem;
   }
}