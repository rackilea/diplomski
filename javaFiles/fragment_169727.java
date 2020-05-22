import javax.naming.InvalidNameException;
public class NameApp{
   public static void main(String[] args) {
      Name aa = new Name();
      try {
            System.out.print("Enter your name: ");
            String in = "George Den";
            aa.printName(in);
            in = "George";
            aa.printName(in);
      }
      catch(InvalidNameException e){
         System.out.println(e.toString());
      }
   }
}

import javax.naming.InvalidNameException;
public class Name {
    public void printName(String name) throws InvalidNameException {
        try {
            String[] nameSplit = name.split(" ");
            String first = nameSplit[0];
            String last = nameSplit[1];
            System.out.println("First name: " + first);
            System.out.println("Last name: " + last);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new InvalidNameException("Missing space in: " + name);
        }
    }
}