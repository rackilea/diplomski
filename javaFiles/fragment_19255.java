@Entity
public class Tag{
    ...

    private Post post;

    @ManyToOne
    @JoinTable(name = "posts_tags",
            joinColumns = {@JoinColumn(name = "tag_id")},
            inverseJoinColumns = {@JoinColumn(name = "post_id")})
    public Post getPost(){
        return post;
    }

    ...
}