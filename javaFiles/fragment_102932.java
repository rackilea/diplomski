public class Cls {

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
        System.out.println(Arrays.toString(edges));
        //Output
       //[edge{w=0.0, a=0, b=1}, edge{w=0.0, a=1, b=2}, edge{w=0.0, a=2, b=3}, edge{w=0.0, a=3, b=4}, edge{w=0.0, a=4, b=5}]
    }
}

class Edge {

    public double w = 0;
    public int a = 0;
    public int b = 0;

    @Override
    public String toString() {
       return "edge{" + "w=" + w + ", a=" + a + ", b=" + b + '}';
    }

}