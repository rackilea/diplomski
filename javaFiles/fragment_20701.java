@Entity
@Indexed
@Table(name = "product")
public class Product {

    @Id
    private int id;

    @Field(termVector = TermVector.YES)
    private String productName;

    @Field(termVector = TermVector.YES)
    private String description;

    @Field
    private int memory;

    // getters, setters, and constructors
}