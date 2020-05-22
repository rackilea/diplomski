public class MyComparator implements Comparator<MyClass> {
    @Override
    int compate (MyClass a, MyClass b) {
        // null handling removed for clarity's sake
        // add it if you need it
        return a.getName().compareTo(b.getName());
    }
}