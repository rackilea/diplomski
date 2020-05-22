public class People implements Iterable<Person> {

    private ArrayList<Person> people;

    @Override
    public Iterator<Person> iterator() {
        return Collections.unmodifiableList(people).iterator();
    }

}