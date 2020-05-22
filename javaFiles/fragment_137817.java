@Entity
public class APost implements Serializable {
    ...

    @JoinTable(name="post_likes")
    @ManyToMany(fetch = FetchType.EAGER)
    protected Collection<User> likes;

    @JoinTable(name="post_dislikes")
    @ManyToMany(fetch = FetchType.EAGER)
    protected Collection<User> dislikes;