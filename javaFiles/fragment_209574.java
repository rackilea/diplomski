public class FooComparator implements Comparator<Foo> {
    public int compare(Foo a, Foo b) {
        int dateComparison = a.date.compareTo(b.date);
        return dateComparison == 0 ? a.value.compareTo(b.value) : dateComparison;
    }
}

Collections.sort(foos, new FooComparator());