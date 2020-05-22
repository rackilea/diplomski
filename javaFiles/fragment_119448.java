public class Member implements Comparable<Member> {

    static enum Status {
        NORMAL(1), FRIEND(2), BANNED(3);

        private final int order;

        Status(int order) {
            this.order = order;
        }

        public int getOrder() {
            return this.order;
        }

    };

    private final String name;

    private final Status status;

    public Member(final String name, final Status status) {
        this.name = name;
        this.status = status;
    }

    @Override
    public int compareTo(Member o) {
        if (this.status.equals(o.status)) {
            return this.name.compareTo(o.name);
        } else {
            return this.status.compareTo(o.status);
        }
    }

    @Override
    public String toString() {
        return "Member [name=" + name + ", status=" + status + "]";
    }

    public static void main(String[] args) throws Throwable {
        Member[] members = {
                        new Member("abrt", Status.FRIEND),
                        new Member("dfgh", Status.FRIEND),
                        new Member("abdf", Status.NORMAL),
                        new Member("wert", Status.NORMAL),
                        new Member("andgh", Status.BANNED),
                        new Member("qwer", Status.BANNED)
        };
        List<Member> lst = Arrays.asList(members);
        Collections.sort(lst);
        System.out.println(lst);
    }


}