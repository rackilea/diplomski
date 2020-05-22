public class Main {

static String cmdIF;
static int x = 0;
static int y = 0;
static String northD;
public static void main(String[] args) {

    Scanner input = new Scanner(System.in);

    System.out.println("Welcome to the world! Which way do you want to go?");
    cmdIF = input.nextLine();
    choosePath();
    if(x==1 || y == 0) {
     northD = "You have entered the woods.";
        System.out.println(northD);
    } else {
        System.out.println("You have entered the home");
    }
}
public static void choosePath() {
    //Method return an array of integer
    int[] newPos = actionClass.cmdCenter(cmdIF, x, y);
    //GETX
    System.out.println(newPos[0]);
    //GETY
    System.out.println(newPos[1]);
    //set X
    x = newPos[0];
    //set Y
    y = newPos[1];
}
}