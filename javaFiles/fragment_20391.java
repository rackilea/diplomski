public class UniqueCustomerNumber {

    private String customerID;

    public void setCustNum() {
        Random x = new Random();
        this.customerID = Integer.toString(x.nextInt(800000001) + 100000000);
    }

    public String getCustNum() {
        return this.customerID;
    }
}