public class XpathObject {
    public final String type; // Or protected final
    public final String xpath;
    public Optional<String> xpathBis = Optional.empty();

    public XpathObject(String type, String xpath) { // Or protected
        this.type = type;
        this.xpath = xpath;
    }
}