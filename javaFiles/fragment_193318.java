public class SecondThanFirstComparator implements Comparator<Person> {
   public int compare(Person p1, Person p2) {
       // Handle nulls

       if (p1.getSecondName().equals(p2.getSecondName())) {
           return p1.getFirstName().compareTo(p2.getFirstName());
       } else {
           return p1.getSecondName().compareTo(p2.getSecondName());
       }
       return 0;
     }
}


List<Person> p = ...;

...

Collections.sort(p, new SecondThanFirstComparator());
// From here p list is sorted