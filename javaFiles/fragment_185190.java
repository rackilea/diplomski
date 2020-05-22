import java.util.ArrayList;

public class Person 
{                   // Don't use static here unless you want all of your Person 
                    // objects to have the same data
   String name;
   double age;
   double height;
   double weight;

   public Person(String name, double age, double height, double weight)
   {
      this.name = name;       // Must refer to instance variables that have
      this.age = age;         // the same name as constructor parameters
      this.height = height;    // with the "this" keyword. Can't use 
      this.weight = weight;    // Classname.variable with non-static variables
   }

}

public AnotherClass 
{
   public void someMethod()
   {
      Person joe = new Person("Joe", 30, 70, 180);
      ArrayList<Person> people = new ArrayList<Person>();
      people.add(joe);
      Person steve = new Person("Steve", 28, 70, 170);
      people.add(steve);            // Now Steve and Joe are two separate objects 
                                    // that have their own instance variables
                                    // (non-static)
   }
}