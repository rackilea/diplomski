@Entity(name = "Book")
@Table(name = "book")
@TypeDef(
    typeClass = JsonBinaryType.class, 
    defaultForType = JsonNode.class
)
public class Book {

    @Id
    @GeneratedValue
    private Long id;

    @NaturalId
    private String isbn;

    @Column(columnDefinition = "jsonb")
    private JsonNode properties;

    //Getters and setters omitted for brevity
}