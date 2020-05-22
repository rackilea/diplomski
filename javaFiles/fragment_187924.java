Grid table...
table.setHeightMode(HeightMode.ROW);
table.setDetailsGenerator(new DetailsGenerator() {

   public Component getDetails(RowReference rowReference) {
      table.setHeightByRows(tableContainer.getItemIds().size() + 4);
      //detalis height is constant so I solve this by adding extra space which equals the size of 4 the rows
      //
      //for filtered container you can use tableContainer.getVisibleItemIds()
   }
}