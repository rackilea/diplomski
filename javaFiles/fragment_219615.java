public class DogDriver{
public static void main(String args[]){
    System.out.println("\nWhat trick shall Sparky do?");
    System.out.println("Roll Over");
    System.out.println("Jump");
    System.out.println("Sit");
    System.out.println("Bark");

    System.out.print("\nYour command: ");
   final String command = keyboard.nextLine();

    Dog dog = new Dog();
   String response = dog.getResponse(command);
    System.out.println(response);
}
}