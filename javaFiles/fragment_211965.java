public class Person {
  private final Date dateOfBirth;

  ...

  public Date getDateOfBirth() { return dateOfBirth; }
}

Person person = new Person(...);
Date date1 = person.getDateOfBirth();
date1.setTime(1000000000L);
System.out.println(person.getDateOfBirth());