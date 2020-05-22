public class People {
private String name;
private String phone;
private String address;
public People(String name, String phone, String address) {
    this.name = name;
    this.phone = phone;
    this.address = address;
}
/**
 * @return the name
 */
public String getName() {
    return name;
}
/**
 * @param name the name to set
 */
public void setName(String name) {
    this.name = name;
}
/**
 * @return the phone
 */
public String getPhone() {
    return phone;
}
/**
 * @param phone the phone to set
 */
public void setPhone(String phone) {
    this.phone = phone;
}
/**
 * @return the address
 */
public String getAddress() {
    return address;
}
/**
 * @param address the address to set
 */
public void setAddress(String address) {
    this.address = address;
}

}