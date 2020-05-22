import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main( String[] args ) {
        Node nd = getInstance();
        Set<Node> ndSet = nd.getNeighbour();
        ndSet.add( new NodeSign() );
        nd.removeSingleNeighbor(); //throws ClassCastException
    }

    static Node getInstance() {
        return new NodeVariable();
    }
}

interface Node {
    public Set<Node> getNeighbour();
    public void removeSingleNeighbor();
}

class NodeVariable implements Node {
    Set<NodeFunction> ndFuncList = new HashSet<NodeFunction>();
    public Set<NodeFunction> getNeighbour(){ return ndFuncList; } //wont' compile

    //HERE!!!!

    public void removeSingleNeighbor() { 
        NodeFunction ndFunc = (NodeFunction)ndFuncList.toArray()[ndFuncList.size()-1]; //throws ClassCastException
    }
}

class NodeFunction implements Node {
    public Set<NodeFunction> getNeighbour(){ return null; } //won't compile
    public void removeSingleNeighbor() {}
}

class NodeSign implements Node {
    public Set<NodeFunction> getNeighbour(){ return null; } //won't compile
    public void removeSingleNeighbor() {}
}