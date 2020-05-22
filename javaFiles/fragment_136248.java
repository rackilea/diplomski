public class NodeList {
    @JsonManagedReference
    public List<NodeForList> nodes; //this one gets serialized
}

public class NodeForList {
    public String name;

    @JsonBackReference 
    public NodeList parent; //this one wont get serialized, but will be reconstructed upon deserialization

    public NodeForList() { this(null); }
    public NodeForList(String n) { name = n; }
}