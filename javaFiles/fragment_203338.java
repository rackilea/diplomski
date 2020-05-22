@Entity
@Table(name = "video_info")
public class VideoInfo {
    @Id
    private int resourceId;
    @Column(name = "type")
    private String type;
    @Column(name = "time")
    private Integer time;
    @Column(name = "actors")
    private String actors;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "resourceId")
    @MapsId
    private Resource resource;

    //getters and setters
}