public class DataCollection implements java.io.Serializable{

    private String Name;
    private String Address;
    private int Age;
    public DataCollection(String name, String address, int age){
            this.Name=name;
            this.Address=address;
            this.Age=age;
    }
}