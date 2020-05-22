@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name="increment", strategy = "increment")
    private int userID;
    private String name;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "friendships", joinColumns = @JoinColumn(name="requesteruserID"), inverseJoinColumns = @JoinColumn(name="requesteduserID"))
    @WhereJoinTable(clause = "accepted = 'TRUE'")
    private Set<User> friends = new HashSet<User>();

    @Transient
    private Set<User> friendListSnapshot;

    @Transient
    private boolean friendListInitialized = false;

    public User(){}

    public User(int userID, String name) {
        this.userID = userID;
        this.name = name;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
         this.name = name;
    }

    public Set<User> getFriends() {
        return friends;
    }

   public void setFriends(Set<User> friends) {
       this.friendsListInitialized = false;
       this.friendsListSnapshot = null; 
       this.friends = friends;
   }

    public void initFriends(){
        ((PersistentSet)friends).forceInitialization();
        this.friendsListSnapshot = ((Map<User, ?>)((PersistentSet) friends).getStoredSnapshot()).keySet();
        this.friendsListInitialized = true;
    }
}