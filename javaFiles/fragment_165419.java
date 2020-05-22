public class ContactInfo {
    private PhoneNumber phoneNo;
    public Long getPhoneNo() {
        return phoneNo.getNumber();
    }
    public void setPhoneNo(Long phoneNo) {
        this.phoneNo = new PhoneNumber(phoneNo);
    }
}
public class PhoneNumber {
    private Long number;
    public PhoneNumber(Long number) {
        this.number = number;
    }
    public Long getNumber() {
        return number;
    }
}