public class NewRssParser extends RSS094Parser implements WireFeedParser {

public NewRssParser() {
    this("rss_2.0");
}

protected NewRssParser(String type) {
    super(type);
}

protected String getRSSVersion() {
    return "2.0";
}

protected boolean isHourFormat24(Element rssRoot) {
    return false;
}

protected Description parseItemDescription(Element rssRoot, Element eDesc) {
    Description desc = super.parseItemDescription(rssRoot, eDesc);
    desc.setType("text/html"); // change as per
                                // https://rome.dev.java.net/issues/show_bug.cgi?id=26
    return desc;
}

public boolean isMyType(Document document) {
    boolean ok;
    Element rssRoot = document.getRootElement();
    ok = rssRoot.getName().equals("rss");
    if (ok) {
        ok = false;
        Attribute version = rssRoot.getAttribute("version");
        if (version != null) {
            // At this point, as far ROME is concerned RSS 2.0, 2.00 and
            // 2.0.X are all the same, so let's use startsWith for leniency.
            ok = version.getValue().startsWith(getRSSVersion());
        }
    }
    return ok;
}

@Override
public Item parseItem(Element arg0, Element arg1) {
    Item item = super.parseItem(arg0, arg1);

    Element imageElement = arg1.getChild("image", getRSSNamespace());
    if (imageElement != null) {
        String imageUrl = imageElement.getText();

        Element urlElement = imageElement.getChild("url");
        imageUrl = urlElement != null ? urlElement.getText() : imageUrl;

        Enclosure enc = new Enclosure();
        enc.setType("image");
        enc.setUrl(imageUrl);

        item.getEnclosures().add(enc);
    }

    return item;
}

}