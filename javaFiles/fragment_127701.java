@XmlAccessorType(XmlAccessType.FIELD)
public class Product {

    @XmlAttribute
    private String identifier;
    @XmlAttribute
    private Double price;
    @XmlElement(name="Book")
    private Book book;

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
    public Book getBook() {
        return book;
    }
   public void setBook(Book book) {
        this.book = book;
   }
}