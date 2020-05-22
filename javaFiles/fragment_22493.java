public class ... extends ... implements Comparable<Column> {

    @Override
    public int compareTo(Column o) {
       return Integer.compare(disparityRating, o.disparityRating);
    }
}