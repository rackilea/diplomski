public class PetShop {
String name;
String openingTime;
String address;
String phoneNumber;
String website;

public PetShop(String name, String openingTime, String address, String phoneNumber, String website) {
    this.name = name;
    this.openingTime = openingTime;
    this.address = address;
    this.phoneNumber = phoneNumber;
    this.website = website;
}

public String getName() {
    return name;
}

public String getOpeningTime() {
    return openingTime;
}

public String getAddress() {
    return address;
}

public String getPhoneNumber() {
    return phoneNumber;
}

public String getWebsite() {
    return website;
}}