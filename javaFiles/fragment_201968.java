public class FindPath {

    public static void main(String [] args) {
        Node a = new Node("a");
        Node b = new Node("b");
        Node c = new Node("c");
        Node d = new Node("d");
        Node e = new Node("e");
        Node f = new Node("f");
        Node g = new Node("g");
        Node h = new Node("h");
        Node z = new Node("z");
        a.add(b); a.add(c); a.add(z);
        b.add(e); b.add(d);
        e.add(f); e.add(g);
        f.add(e);
        c.add(g);
        g.add(h);
        ArrayList<ArrayList<Node>> viablePaths = new ArrayList<ArrayList<Node>>();
        findPaths(a, "h", new ArrayList<Node>(), viablePaths);
        for (ArrayList<Node> path: viablePaths) {
            print(path);
        }
    }

    public static void findPaths(Node start, String endName, ArrayList<Node> startingPath, ArrayList<ArrayList<Node>> viablePaths) {
        startingPath.add(start);
        for (Node next: start.children) {
            ArrayList<Node> extendedPath = (ArrayList<Node>) startingPath.clone();
            if (next.equals(endName)) {
                extendedPath.add(next);
                viablePaths.add(extendedPath);
            } else {
                boolean nodeAlreadyUsed = false;
                for (Node existingNode: startingPath) {
                    if (next.equals(existingNode)) nodeAlreadyUsed = true;
                }
                if (!nodeAlreadyUsed) {
                    findPaths(next, endName, extendedPath, viablePaths);
                }
            }
        }
    }

    public static void print(ArrayList<Node> path) {
        StringBuffer sb = new StringBuffer();
        for (Node node: path) sb.append(node + " ");
        System.out.println(sb);
    }
}

class Node {
    public String name;
    public ArrayList<Node> children = new ArrayList<Node>();
    public Node(String name) {this.name = name;}
    public boolean equals (Node other) {return other.name.equals(name);}
    public boolean equals (String other) {return other.equals(name);}
    public void add(Node child) {children.add(child);}
    public String toString() {return name;}
}