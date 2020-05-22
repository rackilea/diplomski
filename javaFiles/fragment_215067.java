package at.corba.test.builder;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Builder for generating graphs.
 * @author ChrLipp
 */
public class GraphBuilder {
    /** List of StateBuilder, accesable via nodeNumber. */
    Map<Integer, StateBuilder> stateBuilderMap = new LinkedHashMap<Integer, StateBuilder>();

    /**
     * Delegates node-specific building to NodeBuilder.
     * @param nodeNumber Number of node to create
     * @return NodeBuilder for the node instance to create.
     */
    public StateBuilder createNode(final int nodeNumber) {
        StateBuilder builder = new StateBuilder(this);
        stateBuilderMap.put(nodeNumber, builder);
        return  builder;
    }

    /**
     * Builder function to initialise the graph.
     */
    public SetBasedDirectedGraph build() {
        SetBasedDirectedGraph graph = new SetBasedDirectedGraph();

        for (int key : stateBuilderMap.keySet()) {
            StateBuilder builder = stateBuilderMap.get(key);
            State state = graph.createNode(key);
            state = builder.build(state);
            graph.addNode(state);
        }

        return graph;
    }
}