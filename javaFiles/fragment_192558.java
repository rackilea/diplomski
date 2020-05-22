public Item(String itemType) {
   if (itemType == null) {
       throw new IllegalArgumentException("null itemType");
   }
   this.itemType = Type.valueOf(itemType);
}