import java.util.ArrayList;
import java.util.List;

/**
 * Person description here
 * @author Michael
 * @link http://stackoverflow.com/questions/15799429/why-am-i-getting-this-error-when-adding-object-to-arraylist-java/15799474?noredirect=1#comment22468741_15799474
 * @since 4/3/13 9:45 PM
 */
public class Person {
    private Integer id;
    private boolean zombie;
    private List<Person> friends;

    public static void main(String [] args) {
        List<Person> lastPeopleStanding = new ArrayList<Person>();
        for (int i = 0; i < 3; ++i) {
            lastPeopleStanding.add(new Person(i));
        }
        lastPeopleStanding.get(0).addFriend(lastPeopleStanding.get(1));
        lastPeopleStanding.get(0).addFriend(lastPeopleStanding.get(2));
        System.out.println(lastPeopleStanding);
    }

    public Person(Integer id) {
        this.id = id;
        this.zombie = false;
        this.friends = new ArrayList<Person>();
    }

    public boolean isZombie() { return this.zombie; }

    // Irreversible!  Once you go zombie, you don't go back
    public void turnToZombie() { this.zombie = true; }

    // Only add a friend if they're not a zombie
    public void addFriend(Person p) {
        if (p != null && !p.isZombie()) {
            this.friends.add(p);
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Person{");
        sb.append("id=").append(id);
        sb.append(", zombie=").append(zombie);
        sb.append(", friends=").append(friends);
        sb.append('}');
        return sb.toString();
    }
}