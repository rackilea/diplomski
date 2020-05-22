public class UserModelClass {
    private String name, sureName, date, phoneNumber;

    public UserModelClass() {}

    public UserModelClass(String name, String sureName, String date, String phoneNumber) {
        this.name = name;
        this.sureName = sureName;
        this.date = date;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {return name;}

    public String getSureName() {return sureName;}

    public String getDate() {return date;}

    public String getPhoneNumber() {return phoneNumber;}
}