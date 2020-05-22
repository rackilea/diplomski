package mm.com.java.so.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TicketingSystem {

    enum TicketType {

        CHILD(18), ADULT(36), SENIOR(32.5);

        TicketType(double price) {
            this.price = price;
        }

        private double price;

        public double getPrice() {
            return price;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String type, again;
        int quantity = 0;
        double totalPrice = 0;
        TicketType ticketType;

        System.out.println("Welcome to the cinemas!\n");

        System.out.println("MAIN MENU\n");
        System.out.println("The cinema has the following options\n");
        System.out.println("1 = Child (4-5 yrs)");
        System.out.println("2 = Adult (18+ yrs)");
        System.out.println("3 = Senior (60+ yrs)");

        do {

            System.out.print("\nEnter your option: ");

            type = br.readLine();

            switch (type) {
                case "1":
                    ticketType = TicketType.CHILD;
                    break;

                case "2":
                    ticketType = TicketType.ADULT;
                    break;

                default:
                    ticketType = TicketType.SENIOR;
                    break;
            }

            System.out.print("Enter the number of tickets: ");

            quantity = Integer.parseInt(br.readLine());

            totalPrice += ticketType.getPrice() * quantity;

            System.out.printf("--> You are purchasing %s - %s Ticket(s) at $%s\n", quantity, ticketType, ticketType.getPrice());

            System.out.print("\nDo you wish to continue?  (Y/N) : ");

            again = br.readLine();

        } while (again.equalsIgnoreCase("y"));

        System.out.printf("\n==> Total Price : $%s \n", totalPrice);
    }
}