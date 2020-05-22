public class SomeClassComparator implements Comparator<SomeClass> {
    @Override
    int compare (SomeClass o1, SomeClass o2) {
        // Just an example
        return Integer.compare(o1.getSomeInt(), o2.getSomeInt());
    }
}