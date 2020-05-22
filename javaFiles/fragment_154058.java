@Entity
@Table(name="Collage"
    ,schema="dbo"
    ,catalog="hayez"
)
public class Collage  implements java.io.Serializable {


    @Id
    @Column(name="id", unique=true, nullable=false)
     private String id;
     @Column(name="code")
     private String code;
     @Column(name="currentVersion")
     private Integer currentVersion;
     @Temporal(TemporalType.TIMESTAMP)
     @Column(name="date", length=23)
     private Date date;
     @Column(name="description")
     private String description;
     @Column(name="remark1")
     private String remark1;
     @Column(name="name1")
     private String name1;
     @Column(name="name2")
     private String name2;
     @Column(name="activated")
     private Boolean activated;
     @Column(name="address")
     private String address;
     @Column(name="phoneNumber")
     private String phoneNumber;
     @Column(name="entityType")
     private String entityType;
     @ManyToOne(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
     @JoinColumn(name="University_Id")
      private University university;


    public Collage() {
    }


 <!-- Setter And Getter Here ... -->
}