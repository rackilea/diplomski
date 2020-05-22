realm.beginTransaction();
Category category = realm.createObjectFromJson(categoryJson);
for (Item item : category.getItems()) {
  item.setCategory(category);
}
realm.commitTransaction();

// Then you can do
realm.where(Item.class).equalTo("category.id", category.getId()).findAll();