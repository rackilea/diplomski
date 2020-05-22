public class Employee {

    private Address address;
    private int id;

    public Employee(int id) {
        super();
        this.id = id;
    } 

    public Address getAddress() {
        return address;
    }
    public void setAddress(Address address) {
        this.address = address;
    }
}