public class Person {
    private String name;
    private String email;
    private List<Person> friends;

    // Leave the rest for you.

    public void addFriend(Person p) { 
        if (p != null) {
            this.friends.add(p);
        }
    }

    public void removeFriend(Person p) {
        this.friends.remove(p);
    }

    public boolean isFriend(Person p) { 
        return this.friends.contains(p);
    }
}