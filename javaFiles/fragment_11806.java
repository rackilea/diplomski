public class CatagoryPk implements Serializable {

    private Integer version;
    private Integer catagoryId;

    public CatagoryPk() {
    }

    public CatagoryPk(Integer version, Integer catagoryId) {
        this.version = version;
        this.catagoryId = catagoryId;
    }
}

@Entity
@IdClass(CatagoryPk.class)
public class Catagory {
    @Column(name="VERSION")
    @Id private Integer version;
    @Column(name="CATAGORY_ID")
    @Id private Integer catagoryId;

    @ManyToOne
    @JoinColumns({
        @JoinColumn(name="VERSION", referencedColumnName="VERSION", insertable=false, updatable=false),
        @JoinColumn(name="PARENT_ID", referencedColumnName="CATAGORY_ID")
    })
    private Catagory parentId;
}