public class Member {
    private String firstName;
    private String lastName;
    private int memberId;
    private int id;
    private String phoneNumber;
    private String member;

    public Member(String firstName, String lastName, int uniqueId, String phoneNumber) {

        this.id = uniqueId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public void printMemberDetails() {
        System.out.println("Member id: " + id);
        System.out.println("first name:  " + firstName);
        System.out.println("lastName:  " + lastName);
        System.out.println("Member phone number:  " + phoneNumber);
    }
}