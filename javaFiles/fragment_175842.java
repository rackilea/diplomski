columns[0] = new TextFilteredPropertyColumn(new Model("Id"), "id", "id") {
 // add the LinkPanel to the cell item
 public void populateItem(Item cellItem, String componentId, IModel model) {
    cellItem.add(new Link<String>(componentId) {

       @Override
       public void onClick() {
         setResponsePage(aPage.class);
         //or do what you want when the link is clicked
       }

       @Override
       public IMarkupFragment getMarkup() {
           // display the content you like - access the properties of your object
           return Markup.of("<div wicket:id='cell'>" + model.getObject() + "</div>");
       }
    });

    // Populate your item here
 }
};