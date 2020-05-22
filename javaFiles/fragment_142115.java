@Entity
public class Provider{
    @Id
    private String id;

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private GlobalRating globalRating;
}

@Entity
public class GlobalRating{
    @Id
    private String id;
}