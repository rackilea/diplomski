public class Member {

    String memberId;

    public Member() {
        //generally we don't do to much things here.
    }

    //getters & setters
}

public class ArrayTest {

    public static final NumberFormat fmt = new DecimalFormat("000000");

    public static void main(String[] args) {

        // put this accounts field out of your Member class
        List<Member> accounts = new ArrayList<Member>();
        // TODO fetch your data from database

        for (int i = 0; i < 10; i++) {
            int size = accounts.size() + 1;
            Member member = new Member();
            member.setMemberId("" + 2012 + fmt.format(size));
            accounts.add(member);
        }
    }
}