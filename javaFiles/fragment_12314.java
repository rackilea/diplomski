public class XmlEntry implements Comparable<XmlEntry>{
    private final String mName;
    private final String mType;

    public String getName() {
        return mName;
    }

    public String getType() {
        return mType;
    }

    public XmlEntry(String name, String type) {
        mName = name;
        mType = type;
    }

    @Override
    public int compareTo(XmlEntry xmlEntry) {
        //--sort by name--
        return mName.compareTo(xmlEntry.getName());
    }
}