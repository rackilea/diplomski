@Entity
@Table(name = "people")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "friends", joinColumns = @JoinColumn(name = "person_id"), inverseJoinColumns = @JoinColumn(name = "friend_id"))
    private List<Person> friends;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "enemies", joinColumns = @JoinColumn(name = "person_id"), inverseJoinColumns = @JoinColumn(name = "enemy_id"))
    private List<Person> enemies;

    public Person() {
        friends = new ArrayList<>();
        enemies = new ArrayList<>();
    }

    /**
     * 
     * Optionally force client classes through your add/remove methods if mutual
     * relationship should be maintained.
     * 
     * @return
     */
    public List<Person> getFriends() {
        return Collections.unmodifiableList(friends);
    }

    /**
     * Optionally force client classes through your add/remove methods if mutual
     * relationship should be maintained.
     * 
     * @return
     */
    public List<Person> getEnemies() {
        return Collections.unmodifiableList(enemies);
    }

    /**
     * Ensures mutual relationship set correctly.
     * 
     * @param person
     */
    public void addFriend(Person person) {
        friends.add(person);
        person.friends.add(this);
    }

    /**
     * Ensures mutual relationship set correctly.
     * 
     * @param person
     */
    public void addEnemy(Person person) {
        enemies.add(person);
        person.enemies.add(this);
    }
}