public class Person{
   private int id;
   private String firstName;
   private String lasrName;
   .
   .

   public Person(){
       this.id = 1;
       this.firstName = "First Name";
       this.lastName = "Last Name";
   }

   public String toString(){
       String str = "";

       str += "Person Info: \n";
       str += "Id : " + id + "\n";
       str += "First Name : " + firstName + "\n";
       str += "Last Name : " + lastName + "\n";
       ....

       return str;
   }   

}