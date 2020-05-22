import java.util.*;

public class Members {

    // List of members    
    private List<Member> memberList;
    // for performance you may want to use a map to find elements faster
    // private Map<Integer, Member> memberMap;

    public Members() {
        memberList = new ArrayList<>();
        //memberMap = new HashMap<>();
    }

    public void addMember(String firstName, String lastName, int uniqueId, String phoneNumber) {
        // maybe check if the id already exists
        memberList.add(new Member(firstName, lastName, uniqueId, phoneNumber));
    }

    public Collection<Member> getlistOfMembers() {
        return memberList;
    }

    public void printMemberId(int id) {
        for (Member m : memberList) {
            if (m.getId() == id) {
                m.printMemberDetails();
                return;
            }
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        Members members = new Members();
        members.addMember("Hans", "Mueller", 8, "98365402");
        members.addMember("Hans", "Meister", 233, "98365402");

        members.printMemberId(8); // prints Hans Mueller
        members.printMemberId(123); // prints nothing
        members.printMemberId(233); // prints Hans Meister
    }
}