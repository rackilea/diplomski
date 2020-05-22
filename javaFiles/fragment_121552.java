public class Person {

    @OneToOne
    @JoinColumn(name = "phone_id")
    private Phone phone;

    public String getPhoneNumber() {
        return phone.getNumber();
    }

}