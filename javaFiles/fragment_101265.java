import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.util.Scanner;

public class myMenu {

    public static String names[] = {"HAM", "CHEESE", "FRIES", "DRINKS"};
    public static double prices[] = {3.75, 4.10, 2.50, 1.75};
    public static ArrayList<List<String>> allitems = new ArrayList<>();   
    static double total = 0.0;

    public static void main(String[] args) {
        welcomeCustomer();
        collectItem();
    }

    public static void welcomeCustomer() {
        System.out.println("Welcome to QuickieBurger!");
        for (int i = 0; i < names.length; i++) {
            System.out.println(names[i] + "\t\t\t" + prices[i]);
        }
    }

    public static void collectItem() {
        String userInput = "";
        Scanner kbd = new Scanner(System.in);
        System.out.println("Please place your order (e.g., 3 ham). Enter Q to quit.");
        userInput = kbd.nextLine();
        while (!getGoodOrderLine(userInput)) {
           userInput = kbd.nextLine();
        }

    }
    private static boolean getGoodOrderLine(String userInput) {

        if (userInput.equalsIgnoreCase("q")) {
            transaction();
        } else if (!Character.isDigit(userInput.charAt(0))) {
            System.out.println("quesntity should be specified. try again");
            return false;
        } else {
            for (int i = 0; i < names.length; i++) {
                String items = names[i];
                //get the first charactor from userinput
                char c = 0;
                for(int z=0;z<userInput.length();z++){
                    c=userInput.charAt(z);
                    if(Character.isAlphabetic(c)){
                        break;
                    }
                }
                if (Character.toLowerCase(items.charAt(0)) ==Character.toLowerCase(c)) {

                    String s="";
                    int x=0;
                    while(Character.isDigit(userInput.charAt(x))){
                        s+=userInput.charAt(x);
                        x++;
                    }
                    int quentity=Integer.parseInt(s);
                    double pri = prices[i];
                    double sub = quentity * pri;
                    total += sub;
                    ArrayList<String> subitem = new ArrayList<>();
                    subitem.add(items);
                    subitem.add(String.valueOf(quentity));
                    subitem.add(String.valueOf(sub));
                    allitems.add(subitem);
                    return false;
                }
            }
            System.out.println("this not a valid food item.try again");
        }

        return false;

    }

    private static void transaction() {
        //ending program
        Date today = new Date();
        System.out.println("-------------------------------------");
        System.out.println("Date: " + today);
        for (List<String> menu : allitems) {
            System.out.println(menu.get(0)+"   "+menu.get(1)+"  = "+menu.get(2));
        }
        System.out.println("Please pay " + total + "\n");
        System.out.println("------------------------------------");
        System.out.println("End of processing");
    }
}