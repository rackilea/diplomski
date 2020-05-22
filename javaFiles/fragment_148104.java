import java.util.Random;

Random random = new Random();

Edge[] edges = new Edge[800];
for(int i = 0; i < edges.length; i++) {
    edges[i] = new Edge(
        Integer.toString(random.nextInt(100)),
        Integer.toString(random.nextInt(100)));
        random.nextInt(300) //weights from 0 to 299
    );
}