@Entity
public class Article {
  @Id
  @Column(name = "article_id")
  private Long id;

  @ElementCollection
  private Map<String, String> textMap;
}