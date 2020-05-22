package stackoverflow.model;

import java.util.Map;

/**
 * Shard
 */
public class Shard {

    private String range;
    private String state;
    private Map<String, CoreNode> replicas;

    public Shard() {
        super();
    }

    public String getRange() {
        return this.range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<CoreNode> getReplicas() {
        return this.replicas;
    }

    public void setReplicas(List<CoreNode> replicas) {
        this.replicas = replicas;
    }

}