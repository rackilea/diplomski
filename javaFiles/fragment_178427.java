public static void main(String[] args) {
    Category mainCat = new Category();
    mainCat.setName("TITLE");
    System.out.println(mainCat.getName()); 

    Subcategory m = mainCat.createSubcategory("SUBTITLE1");
    System.out.println(m.getName());
    System.out.println(m.getParent());
}