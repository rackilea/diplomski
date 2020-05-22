import java.util.Scanner;
public class Main
{
public static void main (String args[]) 
{
MainObject[] Main = new MainObject[99];
//^objects created will be added to this array^
String input;
Scanner scanner = new Scanner(System.in);
int nextSpot = 0;
do
{
    System.out.println("1. Add a new object 1");
    System.out.println("2. Add a new object 2");
    System.out.println("3. Display all object info");
    System.out.println("4. Quit");

    System.out.print("Please enter either 1 to 4: "); 
    input =(scanner.nextLine());

    switch(input) {
    case 1 :
    if (nextSpot < Main.length) {
        object1 obj1 = new object1();
        System.out.println("Please enter name of object: ");
        obj1.setName(scanner.nextLine());
        obj1.display();
        Main[nextSpot++] = obj1;
    }
    else {
        System.out.println("Error!");
    }
    break;

    // etc.

    }
}
while (input==1 || input==2 || input==3)