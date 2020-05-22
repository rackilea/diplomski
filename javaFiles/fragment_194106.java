import java.util.Scanner;
public class Test {

    String pw = "one";
    String pw2;

    /* this is the constructor for your class 
    you can override existing variables or 
    set a variable that is declared in the header of your class
    inside the constructor of your class. It will run whenever you
    create a new object for that class */

    public Test(String pw2Param) {
         this.pw2 = pw2Param;
    }

    public static void main(String[] args){
        {    
            Scanner sc = new Scanner(System.in);

            // instantiate an object that will hold the information you need 
            Test obj = new Test("two");
            System.out.println(obj.pw);
            // "one"
            System.out.println(obj.pw2);
            // "two"

            System.out.println("Enter your password:");
            String password = sc.next();

            if (password.equals(obj.pw)) {
                System.out.println("You have typed 'one' and logged in successfully");
            } else if(password.equals(obj.pw2)) {
                System.out.println("You have typed 'two' and logged in successfully");
            } else {
                System.out.println("I didn't get that");
            }
        }
    }
}