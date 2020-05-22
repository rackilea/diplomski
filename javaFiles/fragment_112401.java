import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "product")
@XmlAccessorType (XmlAccessType.FIELD)
public class Product {
    private String Name;
    private int price;

    public String getName() {
        return Name;
    }

    public int getPrice() {
        return price;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}