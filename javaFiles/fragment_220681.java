/**
 * Public class to run the demo
 *
 */
public class ArraylistObjectModify {

public static void main(String args[]) {

    // Add an arraylist and add elements to it
    ArrayList<Person> personList = new ArrayList<Person>();
    personList.add(new Person("Juned",32,"Bangalore"));
    personList.add(new Person("Ahsan",31,"Delhi"));
    personList.add(new Person("Sniper",1,"Grave"));

    //Print list elements before change
    System.out.println("Arraylist pre objects modification");
    System.out.println("----------------------------------");
    for(Person person:personList) {
        System.out.println(person);
    }

    for(Person person:personList) {
        if(person.getName().equals("Juned")) {
            person.setName("ChangedJuned");
            person.setAddress("Hola-lulu");
        }
    }

    //Print list elements after change
    System.out.println("Arraylist post objects modification");
    System.out.println("----------------------------------");
    for(Person person:personList) {
        System.out.println(person);
    }


}

}