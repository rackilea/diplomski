@Entity
@Table(name = "bericht")
@Proxy(lazy = false)
public class Bericht implements Serializable {

    @OneToOne(mappedBy = "parent", cascade = CascadeType.DELETE)
    private Bericht child;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    @JoinColumn(name = "PARENT_ID")
    private Bericht parent;

    //additionally always ensure both sides of the relationship are consistent

    public void setChild(Bericht child){
       this.child = child;
       child.parent = this;
    }

    public void setParent(Bericht parent){
       this.parent = parent;
       parent.child = this;
    }
}