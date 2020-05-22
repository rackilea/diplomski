// maps to the root-"xml" element in the file
@XmlRootElement( name="xml" )
@XmlAccessorType( XmlAccessType.FIELD )
public class Xml {

    // this is standard JAXB
    @XmlElement;               
    private Item item;
    public Item getItem() {    
        return this.item;
    }

    ...
}

// maps to the "<xml><item>"-element in the file
public class Item {

    // standard JAXB; maps to "<xml><item id="...">"
    @XmlAttribute              
    private String id;
    public String getId() {
        return this.id;
    }

    // getting an attribute buried deep down
    // MOXY; maps to "<xml><item><rating average="...">"
    @XmlPath( "rating/@average" )    
    private Double averageRating;
    public Double getAverageRating() {
        return this.average;
    }

    // getting a list buried deep down
    // MOXY; maps to "<xml><item><service><identification><aliases><alias.../><alias.../>"
    @XmlPath( "service/identification/aliases/alias/text()" )
    private List<String> aliases;
    public List<String> getAliases() {
        return this.aliases;
    }

    // using a getter to massage the value
    @XmlElement(name="dateforindex")
    private String dateForIndex;
    public Date getDateForIndex() {
        // logic to parse the string-value into a Date
    }

}