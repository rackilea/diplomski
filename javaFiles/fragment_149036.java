public class OwnComparator implements Comparator<Dados> {
    @Override
    public int compare(Dados obj1, Dados obj2) {
        return obj1.text.compareTo(obj2.text); // Sort based on "text" field
    }
}