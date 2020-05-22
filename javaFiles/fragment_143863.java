public class Person implements Comparable<Person>{

public int compareTo(Person person) {
  if(this.name != null && person.name != null){
   return this.name.compareToIgnoreCase(person.name);
  }
  return 0;
 }

}