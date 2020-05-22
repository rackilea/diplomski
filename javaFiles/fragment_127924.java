public class XpathObject {
    public final String type; // Or protected final
    public final String xpath;

    public XpathObject(String type, String xpath) { // Or protected
        this.type = type;
        this.xpath = xpath;
    }
}

public class XpathObjectLabel {
    public final String xpathBis;

    public XpathObjectLabel(String xpath, String xpathBis) {
        super("label", xpath);
        this.xpathBis = xpathBis;
    }
}