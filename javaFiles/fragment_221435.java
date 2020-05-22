import java.util.ArrayList;
import java.util.Scanner;

public class List{

    static ArrayList<String> alist = new ArrayList<String>();
    static Scanner sc = new Scanner(System.in);
    static String choice;

public static void main(String args[]){
    mainMenue();
}

private static void mainMenue() {
     System.out.println("1. do shopping \n2. check basket \n3. go to checkout");
     choice = sc.next();
     if(choice.equals("1")) shoppingMenue();
     else if(choice.equals("2")) checkingMenue();
     else if(choice.equals("3")) checkoutMenue();
}

private static void checkoutMenue() {
    System.out.println("Are you sure you want to checkout? \n1. No \n2. Yes");
    choice = sc.next();
    if(choice.equals("1"))return;
    else System.out.println("test");
}

private static void checkingMenue() {
    System.out.println(alist);
}

private static void shoppingMenue() {
    boolean stop = false;
    while(!stop){
        System.out.println("1. Veg \n2. sweets \n3. drink \n4. toiletries \n5. 
alcohol \n6. go back");
        choice = sc.next();
        if(choice.equals("1")) printAndSave(1);
        else if(choice.equals("2")) printAndSave(2);
        else if(choice.equals("3")) printAndSave(3);
        else if(choice.equals("4")) printAndSave(4);
        else if(choice.equals("5")) {
            System.out.println("Check ID if age is under 25 \nHow old are you?");
            if(sc.nextInt() < 18) System.out.println("You are not old enough to buy 
alcohol");
            else printAndSave(5);
        }
        else if(choice.equals("6")) mainMenue();
    }
}

private static void printAndSave(int i) {
    ArrayList <String> textList = new ArrayList <>(6);
    textList.add(0, "");
    textList.add(1, "Veg has been added to your basket");
    textList.add(2, "Sweets have been added to your basket");
    textList.add(3, "Drinks have been added to your basket");
    textList.add(4, "Toiletries have been added to your basket");
    textList.add(5, "Alcohol has been added to your basket");

    System.out.println(textList.get(i));
    alist.add("veg");
    }
}