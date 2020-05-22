import java.util.Scanner;
class Booking{
    public  static   class Ticket{
        int Amount;     //To be used to record how many of a specific ticket are needed.
        int Price =6;
        public  void SetAmount(int Order){
            this.Amount = Order;
System.out.println("SetAmount="+Order);
        } 
    }
    public static void main(String args[]) {
      Booking.Ticket ticket=new Booking.Ticket();  
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many tickets would you like?");
        int AmountBooked = scanner.nextInt();
        ticket.SetAmount(AmountBooked);
    }
}