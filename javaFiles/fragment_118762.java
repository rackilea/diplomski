public class EmployeeDetails {

    String name;
    String address;
    String city;
    String zipcode;

    public EmployeeDetails(String name, String address, String city, String zipcode) {
        this.name = name;
        this.address = address;
        this.city = city;
        this.zipcode = zipcode;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAddres(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setZip(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getZip() {
        return zipcode;
    }

    public String toString() {
        return name + " " + address + " " + city + " " + zipcode;
    }

}