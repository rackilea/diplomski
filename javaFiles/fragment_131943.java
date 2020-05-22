public class ComplexComparator implements Comparator<Book>{

    private Comparator<Book> comp;

    public ComplexComparator(Comparator<Book> x, Comparator<Book> y) {
        comp = x.thenComparing(y);
    }

    public ComplexComparator(Comparator<Book> x, boolean h, Comparator<Book> y, boolean i) {
        if (h && i) {
            comp = x.thenComparing(y);
        } else if (h) {
            comp = x.thenComparing(y.reversed());
        } else if (i) {
            comp = x.reversed().thenComparing(y);
        } else {
            comp = x.reversed().thenComparing(y.reversed());
        }
    }

    @Override
    public int compare(Book o1, Book o2) {
        return comp.compare(o1, o2);
    }
}