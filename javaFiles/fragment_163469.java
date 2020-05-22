public class MyComparator implements Comparator<Person> {
    private final int refAge;

    public MyComparator(int refAge) {
        this.refAge = refAge;
    }

    @Override
    public int compare(Person p1, Person p2) {
        return Integer.compare(Math.abs(p1.getAge()-refAge),
                Math.abs(p2.getAge()-refAge));
    }
}