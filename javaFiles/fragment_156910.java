@ManagedBean
public class Poll {

    @ManagedProperty(value="#{param.msg}")
    private String msg;

    @PostConstruct
    public void init() {
        // Do something with msg.
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}