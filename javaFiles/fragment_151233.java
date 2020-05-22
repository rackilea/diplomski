import java.util.List;

public class MemberClass {

    private List<MemberProfile> member;

    public List<MemberProfile> getMember() {
        return member;
    }

    public void setMember(List<MemberProfile> member) {
        this.member = member;
    }

    public class MemberProfile {
        int id;
        String name;
        int profileIconId;
        int age;
        String email;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getProfileIconId() {
            return profileIconId;
        }

        public void setProfileIconId(int profileIconId) {
            this.profileIconId = profileIconId;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

    }
}