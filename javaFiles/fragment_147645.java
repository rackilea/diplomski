import java.util.*;
import java.util.concurrent.*;
import java.util.stream.*;

public class Test {

    private static final ThreadLocalRandom RANDOM = ThreadLocalRandom.current();

    public static void main(String[] args) {
        int noOfVertices = 100_000;

        Vertex[] vertexList = new Vertex[noOfVertices];

        IntStream.range(0, noOfVertices).parallel().forEachOrdered(i -> {
            vertexList[i] = new Vertex(i);

            int degree = (int) (500 * RANDOM.nextDouble()); // random choice of degree

            for (int j = 0; j <= degree; j++) {
                int nbr = (int) (noOfVertices * RANDOM.nextDouble()); // randomly choose a neighbor

                vertexList[i].addNeighbour(nbr, RANDOM.nextDouble());
            }
        });
    }

}

class Vertex {

    private int id;

    private Map<Integer, Double> connectedTo;

    private int status;

    public Vertex(int id) {
        this.id = id;

        this.connectedTo = new HashMap<>(500);
    }

    public void addNeighbour(int nbr, double weight) {
        this.connectedTo.put(nbr, weight);
    }

    public int getId() {
        return this.id;
    }

    public double getWeight(int nbr) {
        return this.connectedTo.get(nbr);
    }

    public int getStatus() {
        return this.status;
    }

    public Set<Integer> getConnections() {
        return this.connectedTo.keySet();
    }

}