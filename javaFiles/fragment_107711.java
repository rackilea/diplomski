public class Bank {
private Map<String,Customer> customers = new HashMap<>();

public void addCustomer(String name){

    Customer customer = new Customer(name);
    customers.put(customer.getName(),customer);
    System.out.println("new customer " + customer.getName() + " added");
}

// O(1) -- no need to iterate over an array for deleting customer
public boolean deleteAccount(String name){
    if(customers.containsKey(name)){
        customers.remove(name);
        return true;
    }
    return false;
}

@Override
public String toString() {
    return "Bank{" +
            "customers=" + customers +
            '}';
}

public static void main(String[] args){

    Bank bank = new Bank();                 // create Bank object

    bank.addCustomer("Jhon");       // insert some customer
    bank.addCustomer("Doe");
    System.out.println(bank);
    bank.deleteAccount("Yossi");    // not exists - return false
    bank.deleteAccount("Doe");      // removed - return true

    System.out.println(bank);

}