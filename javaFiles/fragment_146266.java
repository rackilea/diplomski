public class pizza {
public static void main(String[] args){
    pizzaServiceA();
}
public static void pizzaServiceA(){
    Scanner input = new Scanner(System.in);
    double total = 0;
    System.out.println("Enter order:");
    String order = input.next();
    String pizza = "Your order is: ";

    if (order.equals("quit")){
        System.out.println("Program exiting.");
        System.exit(0);
    }

    int count=0;
    boolean size = false;
    for (int x = 0; x < order.length(); x++){
    if (order.charAt(0) == 'm' || order.charAt(0) == 'l'){
        if (order.charAt(x) == 'm' && count ==0){
            total +=4.00;
            pizza += "Medium pizza with,";
            size = true;
        }
        else if (order.charAt(x) == 'm' && count > 0){
            pizza +="mozarella,";
            if(size) total =(long) + 1.00;
            else total+=1.50;
        }
        else if (order.charAt(x) == 'l'){
            total +=5.00;
            pizza +="Large pizza with,";
        }
        else if (order.charAt(x) == 'h'){
            pizza +="ham,";
            if (size) total += 1.40; 
            else total +=2.10;
        }
        else if (order.charAt(x)== 'o'){
            pizza +="olives,";
            if(size) total +=0.80;
            else total +=1.20;
        }
        else if (order.charAt(x)=='p'){
            pizza+="pineapple,";
            if(size) total +=1.00;
            else total+=1.50;
        }
        else if (order.charAt(x)=='s'){
            pizza+="spinach,";
            if(size) total +=0.80;
            else total+=1.20;
        }

    }
    else {
        System.out.println("Your first character must be m(medium) or l(large)");
    }
    count++;
}
    System.out.println(pizza +"£" + String.format("%.2f", total ));
}