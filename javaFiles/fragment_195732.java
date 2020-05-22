public List<SelectItem> getAllCatagories(){

   List<SelectItem> items = new ArrayList<SelectItem>();
   List<Category> categoryList = dao.getAllCategory();
    for(Category category: categotyList){
       items.add(new SelectItem(category.getCategoryId(), category.getName()));
   }
   return items;
}