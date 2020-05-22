import java.util.Scanner;

public class TestClass {

    private static Scanner scanner;
    public static void main(String[] args)
    {
        scanner = new Scanner(System.in);
        ArrayObject array = new ArrayObject();
        String option = "";
        int selection = selectionMenu();
        while(selection != 3){
            if(selection == 1){
                System.out.println("Enter your object");
                String input = scanner.next();
                array.add(input);
            }else if(selection == 2){
                for(Object o : array){
                    System.out.println("Object value: "+o.toString());
                }
            }

            selection = selectionMenu();
        }
        scanner.close();
    }

    public static int selectionMenu(){
        System.out.println("Menu:");
        System.out.println("\t1. Add object");
        System.out.println("\t2. Print objects");
        System.out.println("\t3. Quit:");
        int option =scanner.nextInt(); 
        return option;
    }
}