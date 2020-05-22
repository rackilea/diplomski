public class Node {
    public static void main(String[] args) {
        Node linkedList = new Node(1, null);
        Node node = linkedList;
        for (int i = 2; i < 10; ++i)
            node = node.addNodeAfter(i);
        System.out.println(linkedList.toString(5));
    }

    public String toString(int i) {
        if (i > 0) {
            if (link == null)
                return data.toString();
            else
                return data.toString() + " " + link.toString(i - 1);
        } else
            return "";
    }

    protected Integer data;
    protected Node link;

    public Node(Integer data, Node link) {
        this.data = data;
        this.link = link;
    }

    public Node addNodeAfter(Integer element) {
        return link = new Node(element, link);
    }

    public Integer getData() {
        return data;
    }

    public Node getLink() {
        return link;
    }
}