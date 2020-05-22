@Entity
 @Table(name = “myServer”)
 public class MyDataEntity implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "video_link", nullable = true)
    private String videoLink;

    public MyDataEntity() {

    }

    ...setters&getters
}