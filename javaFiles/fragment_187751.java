public class Details {

String sub_directory_name;
String address;
ArrayList<Email> emailArrayList;
ArrayList<ContactNo> contactNoArrayList;

public String getSub_directory_name() {
    return sub_directory_name;
}

public void setSub_directory_name(String sub_directory_name) {
    this.sub_directory_name = sub_directory_name;
}

public String getAddress() {
    return address;
}

public void setAddress(String address) {
    this.address = address;
}

public ArrayList<Email> getEmailArrayList() {
    return emailArrayList;
}

public void setEmailArrayList(ArrayList<Email> emailArrayList) {
    this.emailArrayList = emailArrayList;
}

public ArrayList<ContactNo> getContactNoArrayList() {
    return contactNoArrayList;
}

public void setContactNoArrayList(ArrayList<ContactNo> contactNoArrayList) {
    this.contactNoArrayList = contactNoArrayList;
}
}