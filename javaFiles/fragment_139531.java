public interface Hypergraph<V, H> {
    // Other definitions
}

...

public class SetHypergraph<V, H> implements Hypergraph<V, H> {
    protected Map<H, Set<V>> edges;
    // Other fields

    public SetHypergraph() {
        edges = new HashMap<H, Set<V>>();        
    }

    // Other methods
}

...

public interface SimpleHypergraph<V extends SimpleV, H extends SimpleH> extends Hypergraph<V, H> {
    H get(int id);
    H get(Set<V> vSet);
}


...

public class SimpleHypergraphImpl<V extends SimpleV, H extends SimpleH> extends SetHypergraph<V, H> implements SimpleHypergraph<V, H> {

    public H get(int id) {
        // your code
        return null;
    }

    public H get(Set<V> vSet) {
        // your code (V is at least SimpleV, so you can use its accessible properties/methods here
        return null;
    }

    // example of usage
    public static void main(String[] args) {
        SimpleHypergraph<SimpleV, SimpleH> simpleHyperGraph = new SimpleHypergraphImpl<SimpleV, SimpleH>();
        Set<SimpleV> set = new HashSet<SimpleV>();
        set.add(new SimpleV(1,1));
        set.add(new ComplicatedV(1000,1000));
        SimpleH h = simpleHyperGraph.get(0);
        h = simpleHyperGraph.get(set);
    }
}


...

public class SimpleV {

    private int id;
    private int weight;

    public SimpleV(int id, int weight) {
        this.id = id;
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    // Other methods
}

...

public class SimpleH {

    private int id;
    private int weight;

    public SimpleH(int id, int weight) {
        this.id = id;
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    // Other methods
}

public class ComplicatedV extends SimpleV {

    public ComplicatedV(int id, int weight) {
        super(id, weight);
    }
}