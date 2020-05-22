package person;

public class Person {
    private  String name;
    private  String friends;

    public static void main(String[] args) {

        Person ted = new Person ("ted");
        Person jim = new Person ("jim");
        Person todd = new Person ("todd");
        Person tom = new Person ("tom");
        Person carl = new Person ("carl");

        // apparently I'm making a mistake here... 
        jim.addFriend(zack);
        System.out.println(jim.getFriends());
    }
    public Person (String aName) {
        name = aName;
        friends = "";
    }
    public void addFriend(Person friend) {

        friends = friends + friend.name + " ";
    }
    public void unFriend (Person nonFriend) {
        friends = friends.replace(nonFriend.name + " ", "");
    }
    public String getFriends () {
        return friends;
    }

}