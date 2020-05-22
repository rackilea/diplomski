public class Person implements Comparable<Person>
{
  private String firstName;
  private String lastName;

  // Getters/Setters

  public int compareTo(Person p)
  {
    return this.lastName.compareTo(p.getLastName());  
  }
}