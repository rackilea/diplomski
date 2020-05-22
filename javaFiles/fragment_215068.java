package at.corba.test.builder;

import java.util.HashMap;
import java.util.Map;

/**
 * Builder for generating states.
 * @author ChrLipp
 */
public class StateBuilder {
    /** Parent builder */
    private final GraphBuilder graphBuilder;

    /** Properties for this node */
    Map<GraphProperties, String> propertyMap = new HashMap<GraphProperties, String>();

    /**
     * ctor.
     * @param graphBuilder  Link to parent builder
     * @param nodeNumber    Node to create
     */
    public StateBuilder(final GraphBuilder graphBuilder)  {
        this.graphBuilder = graphBuilder;
    }

    /**
     * Property setter for property Label.
     * @param label value for property label
     * @return current NodeBuilder instance for method chaining
     */
    public StateBuilder setLabel(final String label) {
        propertyMap.put(GraphProperties.LABEL, label);
        return this;
    }

    /**
     * Property setter for description Label.
     * @param description value for description label
     * @return current NodeBuilder instance for method chaining
     */
    public StateBuilder setDescription(final String description) {
        propertyMap.put(GraphProperties.DESCRIPTION, description);
        return this;
    }

    /**
     * DSL function to close the node section and to return control to the parent builder.
     * @return
     */
    public GraphBuilder add() {
        return graphBuilder;
    }

    /**
     * Builder function to initialise the node.
     * @return newly generated node
     */
    public State build(final State state) {
        for (GraphProperties key : propertyMap.keySet()) {
            String value = propertyMap.get(key);
            state.setProperty(key, value);
        }

        return state;
    }
}