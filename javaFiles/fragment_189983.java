public class Person {
   public String name;
   public int age;

   public Person (String name, int age) {
      this.name = name;
      this.age = age;
   }

   public void setName(String name) {
      this.name = name;
   }

   public void setAge(int age) {
      this.age = age;
   } 

   public String toString() {
      String str;
      str = "My name is "+name+" and I am "+age+" years old!";
      return str;
   }
}//End of Person


public class Main {
   public static void main(String [] args) {
      Person person = new Person("Bob", 15);
      System.out.println(person.toString());
      System.out.println("Switching my name...");
      person.setName("Joe");
      System.out.println(person.toString());
   }
}//End of main