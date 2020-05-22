import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class GraphNode<D> {

    private D data;
    private Set<GraphNode<D>> ins = new HashSet<>();
    private Set<GraphNode<D>> outs = new HashSet<>();

    public GraphNode(D data) {
        this.data = data;
    }

    public D getData() {
        return data;
    }

    public void setData(D data) {
        this.data = data;
    }

    public Set<GraphNode<D>> getIns() {
        return Collections.unmodifiableSet(ins);
    }

    public Set<GraphNode<D>> getOuts() {
        return Collections.unmodifiableSet(outs);
    }

    public void addIn(GraphNode<D> node) {
        if (node == null) {
            throw new NullPointerException(); // Never add null.
        }
        if (ins.add(node)) {
            node.outs.add(this);
        }
    }

    public void addOut(GraphNode<D> node) {
        if (node == null) {
            throw new NullPointerException(); // Never add null.
        }
        if (outs.add(node)) {
            node.ins.add(this);
        }
    }
}