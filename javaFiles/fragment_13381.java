public class Person
{


    int age;
    public Person(int age) throws Exception
    {
       if(age <= 0)
       {

          throw new Exception("Age is not allowed");
       }
       // Do some stuffs
       this.age = age;
    }

}