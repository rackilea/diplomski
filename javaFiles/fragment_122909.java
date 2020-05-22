public class Category {

    @ManyToOne
    private Category superCategory;

    @OneToMany(mappedBy = "superCategory")
    private List<Category> subCategories = new ArrayList<Category>();
}