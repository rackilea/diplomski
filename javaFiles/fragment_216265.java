public class StringList {
    private List<String> mData;

    public StringList(List<String> data) { mData = data; }

    @Override
    public String toString() { return mData.toString(); }
}