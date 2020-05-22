import java.util.ArrayList;
import java.util.List;

public class PersonConverter {

public List<String[]> convertPersonList(List<Person> list) {
    List<String[]> result = new ArrayList<>();

    for (Person p : list) {
        result.add(convertPerson(p));
    }

    return result;
}

private String[] convertPerson(Person p) {
    String[] persontAttributes = new String[3];
    persontAttributes[0] = p.getTitle();
    persontAttributes[1] = p.getFirstName();
    persontAttributes[2] = p.getLastName();
    return persontAttributes;
}
}