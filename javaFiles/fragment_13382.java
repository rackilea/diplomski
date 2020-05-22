public class Person
{


    int age;
    public Person(int age) throws IllegalArgumentException
    {
       if(age <= 0)
       {

          throw new IllegalArgumentException("Age is not allowed");
       }
       // Do some stuffs
       this.age = age;
    }

}