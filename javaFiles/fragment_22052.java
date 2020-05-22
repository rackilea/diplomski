import javax.xml.bind.annotation.adapters.XmlAdapter;

public class PersonAdapter extends XmlAdapter<Person, Person> {

    @Override
    public Person unmarshal(Person person) throws Exception {
        return person;
    }

    @Override
    public Person marshal(Person person) throws Exception {
       if(mull == person || "test10".equals(person.getName()) {
           return null;
       }
       return person;
    }

}