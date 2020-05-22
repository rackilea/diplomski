public class Test {
    static public class Member {

        public int age;
        public String name;
        public String type = "poolMember";

        public Member() {
            type = "poolMember";
        }

        @Override
        public String toString() {
            return "[age = " + age + ", name = " + name + ", type = " + type
                    + "]";
        }
    }

    public static void main(String[] args) {
        String newMembers = "[{\"age\":\"43\",\"name\":\"Jon\"},{\"age\":\"25\",\"name\":\"Tom\",\"type\":\"clubMember\"}]";
        Gson gson = new Gson();
        Type listType = new TypeToken<ArrayList<Member>>() {
        }.getType();
        ArrayList<Member> members = gson.fromJson(newMembers, listType);

        System.out.println(members);

    }
}