import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Customer {
    private String name;
    private  String streetAddress;
    private  String city;
    private  String state;
    private  String zipcode;
    private  String phoneNumber;



    public String getName() {
        return name;
    }



    public void setName(String name) {
        this.name = name;
    }



    public String getStreetAddress() {
        return streetAddress;
    }



    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }



    public String getCity() {
        return city;
    }



    public void setCity(String city) {
        this.city = city;
    }



    public String getState() {
        return state;
    }



    public void setState(String state) {
        this.state = state;
    }



    public String getZipcode() {
        return zipcode;
    }



    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }



    public String getPhoneNumber() {
        return phoneNumber;
    }



    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }



    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        List <Customer> customerList = new ArrayList <Customer>();
        char ans;

        do
        {
            Customer customer = new Customer(); 
            System.out.print("Customer name: ");
            customer.setName(in.next());

            System.out.print("Street Address: ");
            customer.setStreetAddress(in.next());

            System.out.print("City: ");
            customer.setCity(in.next());

            System.out.print("State: ");
            customer.setState(in.next());

            System.out.print("Zipcode: ");
            customer.setZipcode(in.next());

            System.out.print("Phone Number: ");
            customer.setPhoneNumber(in.next());

            customerList.add(customer);

            System.out.print("Would you like to enter in a new customer (y/n)? ");
            String answer = in.next();
            ans = answer.charAt(0);
        }while(ans == 'y');

        for(Customer c: customerList){
            System.out.print(c.getName());

        }

        for(int i=0; i<customerList.size(); i++){
            System.out.print(customerList.get(i).getName());

        }


    }

}