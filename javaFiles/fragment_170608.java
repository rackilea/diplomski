public class Staff extends Employee {    

    private String title;    

    public Staff(String name, String address, String phone, String email, int status, String title) {
        super(name, address, phone, email, status);
        this.title = title;
    }    
}