import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Stack {

    public static void main(String[] args) {
        // Can have as many columns as you want, always assume the last column is the value.
        Object[][] dataFromResultSet = {
                { "n1", "o1", "p1", "c1", 3 },      
                { "n1", "o1", "p1", "c2", 2 },      
                { "n1", "o1", "p2", "c1", 1 },      
                { "n1", "o2", "p1", "c1", 0 },      
                { "n2", "o2", "p1", "c1", 5 }      
        };

        Node root = new Node();

        // Add all records to the hierachy
        for (Object[] row : dataFromResultSet) {
            addToHierachy(root, row);
        }

        // Convert hierachy to JSON
        try {
            JSONArray json = convertToJSON(root);
            System.out.println(json);
        } catch (JSONException e) {
            System.out.println("Something went wrong converting hierachy to JSON");
            e.printStackTrace();
        }
    }

    private static void addToHierachy(Node root, Object[] row) {
        Node current = root;

        // Go through each column in the row
        for(Object col : row) {
            // If this column is a string, then it is a Branch node, not a value one
            // (It might be better to iterate through the array using a counter instead 
            //  and change this condition to say "if it isn't the last column"...)
            if(col instanceof String) {
                // Get (or create) the child node for this column
                current = current.getOrCreateChild((String) col);
            } else {
                // Otherwise, set the value
                current.setValue((Integer) col);
            }
        }
    }

    private static JSONArray convertToJSON(Node root) throws JSONException {
        // Use recursion to build the result JSON
        JSONArray array = new JSONArray();

        // Starting at this root, go through all of the child entries
        for(Map.Entry<String, Node> child : root.getChildren().entrySet()) {
            Node childNode = child.getValue();

            // New object for this entry...
            JSONObject object = new JSONObject();
            // Set the name
            object.put("name", child.getKey());

            // Set the value if it is present on this node
            if(childNode.getValue() != null) {
                object.put("value", childNode.getValue());
            }

            // Generate the child hierarchy if it has children
            if(!childNode.getChildren().isEmpty()) {
                JSONArray childHierachy = convertToJSON(childNode);
                object.put("children", childHierachy);
            }

            array.put(object);
        }

        return array;
    }

    // Class used to build the hierarchy
    static class Node {
        // The map of children, LABEL -> NODE
        private Map<String, Node> children = new HashMap<>();
        // The value (kept as null if this does not have a value set)
        private Integer value;

        public Node getOrCreateChild(String key) {
            Node node = children.get(key);

            if(node == null) {
                node = new Node();
                children.put(key, node);
            }

            return node;
        }

        public Map<String, Node> getChildren() {
            return children;
        }

        public Integer getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }
}