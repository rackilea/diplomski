public class Comp {
    private List<Vert<Integer>> vertList = new ArrayList<Vert<Integer>>();
    private List<Edge> edgeList = new ArrayList<Edge>();

    public Comp(InputStream in) {
        Scanner scanner = new Scanner(in, CHARSET);
        NUM_VERTEX = scanner.nextInt();
        NUM_EDGES = scanner.nextInt();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] vertices = line.split(" ");
            int v1 = Integer.parseInt(vertices[0]);
            int v2 = Integer.parseInt(vertices[1]);
            Vert<Integer> vert1 = new Vert<Integer>(v1); // Change variable name v1 to vert1
            Vert<Integer> vert2 = new Vert<Integer>(v2); // Change variable name v2 to vert2
            Edge e = new Edge(Integer.MIN_VALUE);

            if (vertList.contains(vert1) { // Change variable name v1 to vert1

            }
        }
    }

    /////////////// method 1 ///////////////////
    public boolean hasV(Vert<Integer> v) {
        return vertList.contains(v);
    }

    /////////////// method 2 ///////////////////
    public boolean hasEdge(Edge edge) {
        return edgeList.contains(edge);
    }
}