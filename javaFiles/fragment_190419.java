package stackoverflow.model;

/**
 * CoreNode
 */
public class CoreNode {

    private String state;
    private boolean leader;
    private String core;
    private String node_name;
    private String base_url;

    public CoreNode() {
        super();
    }

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public boolean getLeader() {
        return this.leader;
    }

    public void isLeader(boolean leader) {
        this.leader = leader;
    }

    public String getCore() {
        return this.core;
    }

    public void setCore(String core) {
        this.core = core;
    }

    public String getNode_name() {
        return this.node_name;
    }

    public void setNode_name(String node_name) {
        this.node_name = node_name;
    }

    public String getBase_url() {
        return this.base_url;
    }

    public void setBase_url(String base_url) {
        this.base_url = base_url;
    }

}