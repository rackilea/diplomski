public class IgnoreExtensionComparator implements Comparator<String> {

    public int compare(String s1, String s2) {
        String s1WithoutExtension = s1.substring(0, s1.lastIndexOf("."));
        String s2WithoutExtension = s2.substring(0, s2.lastIndexOf("."));
        return s1WithoutExtension.compareTo(s2WithoutExtension);
    }
}