@XmlRootElement(name="root")
class Root {
    List<Node> nodes;

    @XmlElement(name="node")
    public void setNodes(Node[] nodes) {
        Arrays.sort(nodes);
        this.nodes = Arrays.asList(nodes);
    }
}