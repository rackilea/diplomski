import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Store {

private String storeName;
private List<String> productCodes;

public Store() {
}

public String getName() {
    return name;
}

public List<String> getProductCodes() {
    return productCodes;
}
}