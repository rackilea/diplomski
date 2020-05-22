@Entity
@Table(name = "application_home_screen")
public class ApplicationHomeScreenVO implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @OneToOne(fetch = FetchType.EAGER)
    @Cascade({ CascadeType.ALL })
    @JoinColumn(name="image1_id")
    private ApplicationImageVO image1;

    @OneToOne(fetch = FetchType.EAGER)
    @Cascade({ CascadeType.ALL })
    @JoinColumn(name="image2_id")
    private ApplicationImageVO image2;  
}



@Entity
@Table(name = "application_image")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ApplicationImageVO implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;


    @OneToOne(fetch = FetchType.LAZY, mappedBy = "image1")
    @Cascade({ CascadeType.ALL })
    private ApplicationHomeScreenVO homeScreenImage1;   

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "image2")
    @Cascade({ CascadeType.ALL })
    private ApplicationHomeScreenVO homeScreenImage2;

    @ManyToOne(fetch = FetchType.LAZY, mappedBy = "otherEntity1")
    @Cascade({ CascadeType.ALL })
    private OtherEntity1 otherEntity1;

    @ManyToOne(fetch = FetchType.LAZY, mappedBy = "otherEntity2")
    @Cascade({ CascadeType.ALL })
    private OtherEntity2 otherEntity2;

    @ManyToOne(fetch = FetchType.LAZY, mappedBy = "otherEntity3")
    @Cascade({ CascadeType.ALL })
    private OtherEntity3 otherEntity3;

    @ManyToOne(fetch = FetchType.LAZY, mappedBy = "otherEntity4")
    @Cascade({ CascadeType.ALL })
    private OtherEntity4 otherEntity3;
}