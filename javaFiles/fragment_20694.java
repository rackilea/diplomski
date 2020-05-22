public class ListD 
 {
      int x;  // Create a class attribute
      public ListD() //removing return type as this is constructor 
      { 
        x = 51;  // Set the initial value for the class attribute x
      }

     `public static void main(String []args){
          ListD  myObj = new ListD (); // Create an object of class MyClass (This will call the constructor)
            System.out.println(myObj.x); // Print the value of x
     }
}