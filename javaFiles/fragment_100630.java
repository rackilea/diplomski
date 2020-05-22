public class SubCategoryDTO {

  private String name;
  private CategoryDTO parent;

  public String getCaption() {
    return parent.getName() + " " + name;
  }

}