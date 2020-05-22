IndexedContainer container = new IndexedContainer();
//Add container properties like "name"
//container.addContainerProperty("name", String.class,"");
//From IndexedContainer docs: addContainerProperty(Object propertyId, Class type, Object defaultValue)
container.addItem(1);
Item item = container.getItem(1);
item.getItemProperty("name").setValue(someValue);