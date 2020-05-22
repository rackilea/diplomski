@Embeddable
public class WBListPK implements Serializable {

    private int rid;
    private int sid;

    public WBListPK() {
    }

    public WBListPK(Integer rid, Integer sid) {
        this.rid = rid;
        this.sid = sid;
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }