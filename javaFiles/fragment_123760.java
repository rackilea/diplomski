import java.util.Scanner;


public class home {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        final int MAX = 2;
        Customer [] cust = new Customer[MAX];
        int choice = 0;
        int cnt;

        double total = 0;

        for(cnt=0; cnt < MAX && (choice == 1 || choice ==2 || choice == 0); cnt++){
            System.out.println("For a Service customer type 1, for a Purchaser type 2, to terminate the program press 9");
            choice = s.nextInt();
            switch (choice){
            case 1:
                cust [cnt] = new Service();
                break;
            case 2:
                cust [cnt] = new Purchaser();
                break;
            default:
                break;
            }
        }
        for(int i=0; i < cnt; i++){
           if(cust[i]!= null)
           cust[i].showData();
           total = cust[i].getAmount() + total;
        }
            s.close();

    }
}

abstract class Customer implements Functions {
    protected String name;


}

import java.util.Scanner;


class Service extends Customer {
    protected String date;
    protected double amount;
    public Service () {
        getData();

    }

    public void getData() {     
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the name of the customer");
        name = s.nextLine();
        System.out.println("Enter date of Service: ");
        date = s.nextLine();
        System.out.println("Enter the cost of Service: ");
        amount = s.nextDouble();
    }
    public double getAmount(){
        return this.amount; 
    }
    public void showData() {
        System.out.printf("Customer name: %s The date is: %s, the Amount owed is: %.2f\n",name, date, amount);
    }

}


    import java.util.Scanner;

class Purchaser extends Customer {
    protected double payment;

    public Purchaser(){
        getData();
    }

    public double getAmount(){
        return this.payment; 
    }
    public void getData() {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the name of the customer");
        name = s.nextLine();
        System.out.println("Enter payment amount: ");
        payment = s.nextDouble();
    }
    public void showData() {    
        System.out.printf("Customer name: %s Payment amount is: %.2f\n",name,payment);

    }   
}



interface Functions {
    public void getData();
    public void showData();
    public double getAmount();
}