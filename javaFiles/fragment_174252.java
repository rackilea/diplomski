@Entity
public class TextEntity {
  @Id
  @Column(name = "text_id")
  private Long id;

  @Enumerated
  @Column(name = "text_type")
  private TextType textType;

  @Column(name = "text_content")
  private string text;

  @ManyToOne
  @JoinColumn(name = "article_id", referencedColumnName = "article_id")
  private Article article;
}

public enum TextType {
  TEXT1,
  TEXT2,
  TEXT3,
  TEXT4
}