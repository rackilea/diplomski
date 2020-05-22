public class Data {
    String id;
    String name;
    String pswhash;
    String phone;
    String email;
    String status;
    Date regdate;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPswhash() {
        return pswhash;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getStatus() {
        return status;
    }

    public Date getRegdate() {
        return regdate;
    }

    public Class(String id, String name, String pswhash, String phone, String email, String status, Date regdate) {
        this.id = id;
        this.name = name;
        this.pswhash = pswhash;
        this.phone = phone;
        this.email = email;
        this.status = status;
        this.regdate = regdate;
    }
}