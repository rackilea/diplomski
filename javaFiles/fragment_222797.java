public class NodeProperty {

    private static volatile NodeProperty instance = null;

    private NodeProperty() {
        // instantiatin logic
    }

    public NodeProperty getInstance() {
        if(instance == null) {
            synchronized(NodeProperty.class) {
                if(instance==null) {
                    instance = new NodeProperty();
                }
            } 
        }
    }

}