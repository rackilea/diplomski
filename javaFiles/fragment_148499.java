@Entity
@Table(name = "master")
public class Master implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "seq")
    private Integer seq;

    @OneToOne(mappedBy = "master", cascade = CascadeType.ALL)
    private SubMaster subMaster;

}

@Entity
@Table(name = "sub_master")
public class SubMaster implements java.io.Serializable {

    @Id
    @JoinColumn(name = "seq", referencedColumnName = "seq")
    @OneToOne
    private Master master;

    private String subName;

}