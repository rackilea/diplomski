String[] users = { "Lola,Grimsdyke,89,lgrimsdyke0@facebook.com,Female,Newport Beach,CA",
                    "Sybilla,Martinetto,84,smartinetto1@google.it,Female,Anniston,AL",
                    "Casi,Roizn,78,croizn2@scribd.com,Female,San Jose,CA" };

            ArrayList<UserDetails> list=new ArrayList<>();
            for (int i = 0; i < users.length; i++) {
                String[] sp = users[i].split(",");
                list.add(new UserDetails(sp[0], sp[1], Integer.parseInt(sp[2]), sp[3], sp[4], sp[05]));
            }
            for(UserDetails detail:list) {
                System.out.println(detail);
            }

class UserDetails {
    String firstName;
    String lastName;
    int age;
    String emailId;
    String sex;
    String address;


    public UserDetails(String firstName, String lastName, int age, String emailId, String sex, String address) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.emailId = emailId;
        this.sex = sex;
        this.address = address;
    }


    @Override
    public String toString() {
        return "UserDetails [firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", emailId="
                + emailId + ", sex=" + sex + ", address=" + address + "]";
    }


}