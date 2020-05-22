public class Edge {

    public double w = 0;
    public int a = 0;
    public int b = 0;

    public static void main(String[] args) {

        Edge edges[];
        edges = new Edge[5];
        int c = 10;
        for (int i = 0; i < 5; i++) {
            edges[i] = new Edge();
            edges[i].a = i;
            edges[i].b = i + 1;
            edges[i].w = i / c;
        }

    }
}