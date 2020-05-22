@Root(name = "ASSET", strict = false)
public class Activo {

    @Attribute(name = "rowstamp")
    public String rowstamp;

    @Element(name = "ASSETID")
    public Integer assetid;

    @Element(name = "ASSETNUM")
    public String assetnum;

    @Element(name = "DESCRIPTION")
    public String description;

    @Element(name = "LOCATION")
    public String location;

    @Element(name = "SERIALNUM")
    public String serialnum;

    @Element(name = "SITEID")
    public String siteid;

}