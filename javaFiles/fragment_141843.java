public enum OfferType {
    ONE, TWO;
}


@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private OfferType type;


    public OfferType getType() {
        return type;
    }

    public void setType(OfferType type) {
        this.type = type;
    }
}