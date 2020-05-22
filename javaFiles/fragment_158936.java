import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class NodeAdapter extends XmlAdapter<String, Node>{

    private Map<String, Node> nodes = new HashMap<String, Node>();

    public Map<String, Node> getNodes() {
        return nodes;
    }

    @Override
    public Node unmarshal(String v) throws Exception {
        return nodes.get(v);
    }

    @Override
    public String marshal(Node v) throws Exception {
        return v.getId();
    }

}