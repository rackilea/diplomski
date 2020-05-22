public SubCategory createSubcategory(String name){
    SubCategory m = new SubCategory();
    m.setParent(Category.this);
    m.setName(name);
    return m;
}