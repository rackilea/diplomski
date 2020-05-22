public class AlphabeticOrderProvider implements Comparator<Definition> {
    @Override
    public int compare(Definition o1, Definition o2) {
        return o1.getQualifiedInputName().compareTo(o2.getQualifiedInputName());
    }
}