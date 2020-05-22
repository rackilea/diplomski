public class Node {
    private String text;
    private List<Node> children = new ArrayList<Node>();

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<Node> getChildren() {
        return children;
    }

}