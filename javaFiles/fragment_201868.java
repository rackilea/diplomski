public class CategoriesComparator implements Comparator<Category> {
    @Override
    public int compare(Category category1, Category category2) {
        return category1.getSomeProperty().compareTo(category2.getSomeProperty());
    }
}