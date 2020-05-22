int max = Integer.MIN_VALUE;
Set<Item> maxItems = new LinkedHashSet<>();
for( Item item : items ) {
  //if the item has a greater value clear the set and set the new max value
  if( item.value > max ) {
    maxItems.clear();
    max = item.value;
  }   

  //due to the code above value should always be <= max here, so we just need to check ==
  if( item.value == max ) {
    maxItems.add( item );
  }
}