String input = keyboard.nextLine();        
Member m = new Member(input);

public class Member {
    private String name;
    public Member(String name) {
        this.name = name;
    }

    public void setMembership() {
        try { 
            //Creates a text file with the same name as the username where data is stored.
            Formatter x = new Formatter(name);       
        } catch (Exception e) {
            out.println("Could not create username");
        }
    }
}