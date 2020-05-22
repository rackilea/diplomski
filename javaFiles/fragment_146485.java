import java.util.Arrays;

class FRIEND {
    String name;
    String phone;

    static FRIEND[] MyFriends = {
            new FRIEND("Bob", "5551234"),
            new FRIEND("Jack", "5716666"),
            new FRIEND("Mary", "5341111")
    };

    public FRIEND(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "FRIEND{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Arrays.stream(MyFriends).forEach(System.out::println);
    }

}