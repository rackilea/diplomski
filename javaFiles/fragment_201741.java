import java.util.ArrayList;
import java.util.List;

public class Test {
    private static List<Member> members = new ArrayList<>();

    public static void main(String[] args) {
        members = getTestList(10000);

        warmUp();

        members.remove(9998);
        testSolutions();
        members.remove(1);
        testSolutions();

    }

    private static void warmUp() {
        for (int i = 0; i < 5; i++) {
            for (Member m : members) {
                // warm up cpu for iteration
            }
            members.forEach(Member::getID);
        }
    }

    private static void testSolutions() {
        long start = System.nanoTime();
        int result1 = getNextID();
        System.out.println("#1 Iterative result: " + result1 + " | in " + (System.nanoTime() - start) / 1000000.0 + "ms");
        start = System.nanoTime();
        Member m = members.stream().filter(member -> member.getID() != members.indexOf(member)).findFirst().orElse(null);
        int result2 = m != null ? members.indexOf(m) : members.size();
        System.out.println("#2 Stream Result: " + result2 + " | in " + ((System.nanoTime() - start) / 1000000.0) + "ms");
        start = System.nanoTime();
        int result3 = members.stream().filter(member -> member.getID() != members.indexOf(member)).findFirst().map(m2 -> members.indexOf(m2)).orElse(members.size());
        System.out.println("#3 Stream Result: " + result3 + " | in " + ((System.nanoTime() - start) / 1000000.0) + "ms");
    }

    private static int getNextID() {
        for (int i = 0; i < members.size(); i++) {
            if (i < members.get(i).getID()) {
                return i;
            }
        }
        return members.size();
    }

    private static List<Member> getTestList(int count) {
        List<Member> members = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            members.add(new Member(i));
        }
        return members;
    }

    private static class Member {
        private int id;

        public Member(int id) {
            this.id = id;
        }

        private int getID() {
            return id;
        }
    }
}