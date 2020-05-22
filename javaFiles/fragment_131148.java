public class PersonList {

    private List<Person> list;

    public PersonList(){
        list = new ArrayList<Person>();
    }

    public void add(Person p){
        list.add(p);
    }
}