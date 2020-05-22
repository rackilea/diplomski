@MappedSuperclass 
public class BaseEntity {

  @Column
  private String author;

  public BaseEntity(String author) {
      this.author = author;
  }

  public String getAuthor() {
      return author;
  }

}