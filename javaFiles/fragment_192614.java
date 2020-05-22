@XmlRootElement
public class Response {
    @XmlAttribute(name = "Meta Data")
    private MetaData metaData;
    @XmlAttribute(name = "Stock Quotes")
    private List<StockQuote> stockQuotes;
}

public class MetaData {
    @XmlAttribute(name = "1. Information")
    private String information;
    @XmlAttribute(name = "2. Notes")
    private String notes;
    @XmlAttribute(name = "3. Time Zone")
    private String timeZone;
}

public class StockQuote {
    @XmlAttribute(name = "1. symbol")
    private String symbol;
    @XmlAttribute(name = "2. price")
    private float price;
    @XmlAttribute(name = "3. volume")
    private float volume;
    @XmlAttribute(name = "4. timestamp")
    private String timestamp;
}