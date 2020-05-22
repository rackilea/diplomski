public class Person{
   ...
    public Boolean equals(Object o){
       Person p = (Person) o;
       //you own equals logic
       return isEqual;
    }
    ...
}


public class Community{
    ...
    private Set<Person>;
    ...
}