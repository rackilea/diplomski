@Entity
public class WBList {

    private WBListPK id;
    private String wb;
    private Integer rid;
    private Integer sid;

    @Id
    public WBListPK getId() {
        return id;
    }
    public void setId(WBListPK id) {
        this.id = id;
    }
    @Column(name="wb")
    public String getWb() {
        return wb;
    }
    public void setWb(String wb) {
        this.wb = wb;
    }
}