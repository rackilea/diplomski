import java.util.ArrayList;
import java.util.List;

public class Main {

public static void main(String[] args) {
    //create a person list
    List<Person> personList = new ArrayList<>();

    Person john = new Person("Mr.", "John", "Lenonn");
    Person paul = new Person("Sir", "Paul", "McCartney");

    personList.add(john);
    personList.add(paul);

    //create an instance of the person converter
    PersonConverter pc = new PersonConverter();

    //perform the conversion
    List<String[]> convertedList = pc.convertPersonList(personList);

    //print the result to the console
    for (String[] stringArray : convertedList) {
        for (String s : stringArray) {
            System.out.println(s);
        }
        System.out.println();
    }
}

}