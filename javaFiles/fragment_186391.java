public class Example {

    public static void main(String[] args) {
        List<Node> bestWay = new ArrayList<Node>();
        Node chosen = new Node("Place1");
        String from = chosen
                .add("Place2")
                .add("Place3")
                .add("Place4")
                .add("Place5")
                .nick;
        while (chosen.nick != from) {
            bestWay.add(chosen);
            chosen = chosen.pi;
        }
        System.out.println(bestWay);
    }
}

class Node {

    final String nick;
    Node pi;

    Node(String nick) { this.nick = nick; }

    public Node add(String nick) {
        pi = new Node(nick);
        return pi;
    }

    @Override public String toString() {
        return nick;
    }
}