public void add(Measurable newItem) {
   list.add(newItem);

   if (min == null || min > newItem) {
      min = newItem;
   }
   if (max == null || newItem > max) {
      max = newItem;
   }
}