import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeType;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class JsonModelApp {

    public static void main(String[] args) throws Exception {
        String inputJson = "{\"name\":\"Jake\",\"salary\":3000,\"phones\":"
                + "[{\"phoneType\":\"cell\",\"phoneNumber\":\"111-111-111\"},"
                + "{\"phoneType\":\"work\",\"phoneNumber\":\"222-222-222\"}]," + "\"taskIds\":[11,22,33],"
                + "\"address\":{\"street\":\"101 Blue Dr\",\"city\":\"White Smoke\"}}";
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(inputJson);

        List<Model> models = new TreeModelParser().traverse(rootNode);
        for (Model mod : models) {
            System.out.println(mod + " => Parent: " + mod.getParent());
        }
    }
}

class TreeModelParser {

    private int id = 0;

    public List<Model> traverse(JsonNode root) {
        Model parent = new Model();
        parent.setNodeName("ROOT");

        List<Model> models = new ArrayList<>();
        traverse(models, root, parent);
        return models;
    }

    private void traverse(List<Model> models, JsonNode node, Model parent) {
        if (node.getNodeType() == JsonNodeType.ARRAY) {
            traverseArray(models, node, parent);
        } else if (node.getNodeType() == JsonNodeType.OBJECT) {
            traverseObject(models, node, parent);

        } else {
            throw new RuntimeException("Not yet implemented");
        }
    }

    private void traverseObject(List<Model> models, JsonNode node, Model parent) {
        Iterator<String> fieldNames = node.fieldNames();
        List<String> lst = getListFromIterator(fieldNames);
        for (String fieldName : lst) {
            JsonNode childNode = node.get(fieldName);
            Model model = createModel(childNode, fieldName, parent);
            models.add(model);
            if (traversable(childNode)) {
                traverse(models, childNode, model);
            }
        }
    }

    private void traverseArray(List<Model> models, JsonNode node, Model parent) {
        for (JsonNode jsonArrayNode : node) {
            Model model = createModel(jsonArrayNode, "arrayElement", parent);
            models.add(model);
            if (traversable(jsonArrayNode)) {
                traverse(models, jsonArrayNode, model);
            }
        }
    }

    private static boolean traversable(JsonNode node) {
        return node.getNodeType() == JsonNodeType.OBJECT || node.getNodeType() == JsonNodeType.ARRAY;
    }

    private Model createModel(JsonNode node, String keyName, Model parent) {
        Model model = new Model();
        model.setId(++id);
        model.setNodeName(keyName);
        model.setParent(parent);

        if (node.getNodeType().equals(JsonNodeType.ARRAY)) {
            model.setNodeType("ARRAY");
        } else if (node.getNodeType().equals(JsonNodeType.STRING)) {
            model.setNodeType("STRING");
        } else if (node.getNodeType().equals(JsonNodeType.NUMBER)) {
            model.setNodeType("NUMBER");
        } else if (node.getNodeType().equals(JsonNodeType.OBJECT)) {
            model.setNodeType("OBJECT");
        } else if (node.getNodeType().equals(JsonNodeType.BOOLEAN)) {
            model.setNodeType("BOOLEAN");
        }
        if (!traversable(node)) {
            Object value;
            if (node.isTextual()) {
                value = node.textValue();
                model.setNodeValue((String) value);
            } else if (node.isNumber()) {
                value = node.numberValue();
                model.setNodeValue(value + "");
            }

        }

        return model;
    }

    private static List<String> getListFromIterator(Iterator<String> iterator) {
        List<String> list = new ArrayList<>();
        iterator.forEachRemaining(list::add);
        return list;
    }

}

class Model {
    private long id;
    private String nodeName;
    private String nodeType;
    private String nodeValue;
    private Model parent;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public String getNodeType() {
        return nodeType;
    }

    public void setNodeType(String nodeType) {
        this.nodeType = nodeType;
    }

    public String getNodeValue() {
        return nodeValue;
    }

    public void setNodeValue(String nodeValue) {
        this.nodeValue = nodeValue;
    }

    public Model getParent() {
        return parent;
    }

    public void setParent(Model parent) {
        this.parent = parent;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Model{");
        sb.append("id=").append(id);
        sb.append(", nodeName='").append(nodeName).append('\'');
        sb.append(", nodeType='").append(nodeType).append('\'');
        if (nodeValue != null) {
            sb.append(", nodeValue='").append(nodeValue).append('\'');
        }
        sb.append('}');
        return sb.toString();
    }
}