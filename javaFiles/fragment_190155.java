@Entity
class Video {
    @Id
    int id;

    String url;

    @ManyToOne
    User user;
}