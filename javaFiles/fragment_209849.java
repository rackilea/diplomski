public class Person {
    private String userName;
    private String someUsefulValue;

    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getSomeUsefulValue() {
        return someUsefulValue;
    }
    public void setSomeUsefulValue(String someUsefulValue) {
        this.someUsefulValue = someUsefulValue;
    }
    @Override
    public String toString() {
        return "Person [userName=" + userName + ", someUsefulValue=" + someUsefulValue + "]";
    }