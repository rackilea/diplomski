public class NewNode {

    private Element newElement = new Element(Tag.valueOf("p"), "");
    private List<Node> childs;

    public NewNode(List<Node> childs) {
        this.childs = childs;
    }

    public Node getNewNode() {
        childs.forEach(child -> newElement.appendChild(child.clone()));
        return newElement;
    }

}