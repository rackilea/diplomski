int filterIndex = 1; // juice

// lookup the corresponding category string
String filterCategory = truckcategories.get(filterIndex);

// filter
List<TruckCategoriesModel> filteredList = new ArrayList<>();
for(TruckCategoriesModel tcm : catvals) {
  if(filterCategory.equals(tcm.getCategory())) {
    filteredList.add(tcm);
  }
}