import java.util.ArrayList;
import javax.swing.JOptionPane;

public class market4 {
 public static void main(String[] args) {

    int MenuList; //Declared outside the loop, this will keep the variable in memory as we go through the program. 
    String myOrder = "No order currently set"; //Declared outside the loop for above reasons.  This will become the order.
do{  //Start of Do Loop, this will keep you going through the menu. 

    System.out.println("---MENU---");
    String[] menu = {"[1]item list","[2]sales","[3]print","[4]exit"};
    for (int i=0;i<4;i++) {
        System.out.println(menu[i]);
    }


    String MenuString = JOptionPane.showInputDialog(null, " Choose number: ");
    MenuList = Integer.parseInt(MenuString);


    if(MenuList==1) {
        System.out.println();
        String[] list = {"hotdog","donut","eggpie","pizza","lasagna"};
        int[] cost = {5,15,25,35,45};
        int[] selling = {10,20,30,40,50};
        int[] qty ={5,5,5,5,5};
        System.out.println("item"+"\tcost"+"\tSelling"+"\tinv qty");
        for (int m=0; m<list.length;m++) {
            System.out.println(list[m]+"\t"+cost[m]+"\t\t"+selling[m]+"\t\t"+qty[m]);
        }

        myOrder = "";
        ArrayList<String> Orders = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            String input = (String) JOptionPane.showInputDialog(null,
                "Select an Item", "Welcome " +  "!",
                JOptionPane.QUESTION_MESSAGE, null, list, "Hotdog");



            String[] itemQuantity = { "1", "2", "3", "4", "5" };
            String itemq = (String) JOptionPane.showInputDialog(null,
                "Enter   Quantity", "Welcome",
                JOptionPane.QUESTION_MESSAGE, null, itemQuantity, "1");

            Orders.add("Item " + input + "  Quantity " + itemq);
        }

        for(String s : Orders){
            myOrder += "\n" + s; 
        }
     } else if(MenuList==2) {            
        JOptionPane.showMessageDialog(null,"sales \n" + myOrder);   
    } else if(MenuList==3) {
        JOptionPane.showMessageDialog(null,"print");
        System.out.println(myOrder);
    } else if(MenuList==4) {
        JOptionPane.showMessageDialog(null,"Exit,Bye");
    } else {
        System.out.print("Invalid");
    }
            }while(MenuList != 4); //End of Do loop.  Exiting program when selecting exit (Number 4)
}
}