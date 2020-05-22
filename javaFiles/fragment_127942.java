// add this
public class Customer implements Comparable<Customer> {

    // add this guy
    public int compareTo(Customer other) {
        return this.name.compareTo(other.name); // I'm assuming 'name' is the variable of the name
    }

}