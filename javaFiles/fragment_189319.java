@RelationshipEntity(type = "LIKES")
public class LikedBook {

@Id
@GeneratedValue
private Long id;

private String how;

@StartNode
@JsonIgnore // <- "do not go back"
private User user;

@EndNode
private Book book;