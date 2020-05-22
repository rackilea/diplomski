@Entity
@SqlResultSetMapping(
    name = "ArticleWithHeadline",
    entities = @EntityResult(entityClass = Article.class),
    columns = @ColumnResult(name = "HEADLINE"))
public class Article {
    @Transient
    private String headline;
    ...
}