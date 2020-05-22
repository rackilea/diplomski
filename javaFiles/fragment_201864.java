class Node 
{
    private final String name;
    private final Map<String, Node> children;
    private final CustomObject customObject;

    Node(String name, CustomObject customObject)
    {
        this.name = name;
        this.children = new LinkedHashMap<String, Node>();
        this.customObject = customObject;
    }

    String getName()
    {
        return name;
    }

    void addChild(Node child) 
    {
        children.put(child.getName(), child);
    }

    void removeChild(String name)
    {
        children.remove(name);
    }

    Node getChild(String name)
    {
        return children.get(name);
    }

    Set<Node> getChildren()
    {
        return Collections.unmodifiableSet(
            new LinkedHashSet<Node>(children.values()));
    }