public class CategoriesConverter implements Converter<Categories> {

@Override
public Categories read(InputNode node) throws Exception {
    Categories categories = new Categories(); 
    InputNode childNode = node.getNext(); //InputNode passed there points to the document root, so we're starting from the next one. 
    List<Category> categoriesList = new ArrayList<>(); 
    while( childNode != null ) { // while we're in the document tree
        if (childNode.getName().equals("categories")) {
            InputNode innerChild = childNode.getNext();

            while (innerChild != null) {
                Category category = new Category();
                if (innerChild.getName().equals("category")) {
                    category.setId(Integer.parseInt(innerChild.getAttribute("id").getValue()));
                    category.setText(innerChild.getValue());
                    categoriesList.add(category);
                }

                innerChild = childNode.getNext();
            }
        }

        childNode = node.getNext();
    }

    categories.setCategories(categoriesList);
    return categories;
}

    @Override
    public void write(OutputNode node, Categories value) throws Exception {
        //we don't need to serialize objects now, so it does nothing
    }
}