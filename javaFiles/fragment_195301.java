public class StrCmpLogicalWComparator implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        return Shlwapi.INSTANCE.StrCmpLogicalW(
            new WString(o1), new WString(o2));
    }
}