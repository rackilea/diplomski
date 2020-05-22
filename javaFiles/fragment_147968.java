public class IQUserCustomParam extends IQ
    private final static String childElementName = "usercustomparam";
    private final static String childElementNamespace = "com.records.iq";

public IQUserCustomParam (String color)
    {
        this(childElementName , childElementNamespace );

        this.setType(IQ.Type.result);
        this.setFavouriteColor(color);
    }