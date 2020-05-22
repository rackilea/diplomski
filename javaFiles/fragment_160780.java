@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @OneToMany(mappedBy = "user")
    private Set<ConfirmedFriendship> confirmedFriendships;

    @OneToMany(mappedBy = "user")
    private Set<UnconfirmedFriendship> unconfirmedFriendships;

    public List<User> getConfirmedFriends() {
        return getFriends(confirmedFriendships);
    }

    public List<User> getUnconfirmedFriends() {
        return getFriends(unconfirmedFriendships);
    }

    private List<User> getFriends(Set<?  extends Friendship> friendships){
        List<User> friends = new ArrayList<User>();

        for(Friendship friendship : friendships) {
            friends.add(friendship.getFriend());
        }

        return friends;
    }
}