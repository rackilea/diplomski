import java.util.*;

public class AstarSearch {
    private final Map<Integer, Set<Neighbor>> adjacency;
    private final int destination;

    private final NavigableSet<Step> pending = new TreeSet<>();

    public AstarSearch(Map<Integer, Set<Neighbor>> adjacency, int source, int destination) {
        this.adjacency = adjacency;
        this.destination = destination;

        this.pending.add(new Step(source, null, 0));
    }

    public List<Integer> nextShortestPath() {
        Step current = this.pending.pollFirst();
        while( current != null) {
            if( current.getId() == this.destination )
                return current.generatePath();
            for (Neighbor neighbor : this.adjacency.get(current.id)) {
                if(!current.seen(neighbor.getId())) {
                    final Step nextStep = new Step(neighbor.getId(), current, current.cost + neighbor.cost + predictCost(neighbor.id, this.destination));
                    this.pending.add(nextStep);
                }
            }
            current = this.pending.pollFirst();
        }
        return null;
    }

    protected int predictCost(int source, int destination) {
        return 0; //Behaves identical to Dijkstra's algorithm, override to make it A*
    }

    private static class Step implements Comparable<Step> {
        final int id;
        final Step parent;
        final int cost;

        public Step(int id, Step parent, int cost) {
            this.id = id;
            this.parent = parent;
            this.cost = cost;
        }

        public int getId() {
            return id;
        }

        public Step getParent() {
            return parent;
        }

        public int getCost() {
            return cost;
        }

        public boolean seen(int node) {
            if(this.id == node)
                return true;
            else if(parent == null)
                return false;
            else
                return this.parent.seen(node);
        }

        public List<Integer> generatePath() {
            final List<Integer> path;
            if(this.parent != null)
                path = this.parent.generatePath();
            else
                path = new ArrayList<>();
            path.add(this.id);
            return path;
        }

        @Override
        public int compareTo(Step step) {
            if(step == null)
                return 1;
            if( this.cost != step.cost)
                return Integer.compare(this.cost, step.cost);
            if( this.id != step.id )
                return Integer.compare(this.id, step.id);
            if( this.parent != null )
                this.parent.compareTo(step.parent);
            if(step.parent == null)
                return 0;
            return -1;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Step step = (Step) o;
            return id == step.id &&
                cost == step.cost &&
                Objects.equals(parent, step.parent);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, parent, cost);
        }
    }

   /*******************************************************
   *   Everything below here just sets up your adjacency  *
   *   It will just be helpful for you to be able to test *
   *   It isnt part of the actual A* search algorithm     *
   ********************************************************/

    private static class Neighbor {
        final int id;
        final int cost;

        public Neighbor(int id, int cost) {
            this.id = id;
            this.cost = cost;
        }

        public int getId() {
            return id;
        }

        public int getCost() {
            return cost;
        }
    }

    public static void main(String[] args) {
        final Map<Integer, Set<Neighbor>> adjacency = createAdjacency();
        final AstarSearch search = new AstarSearch(adjacency, 1, 4);
        System.out.println("printing all paths from shortest to longest...");
        List<Integer> path = search.nextShortestPath();
        while(path != null) {
            System.out.println(path);
            path = search.nextShortestPath();
        }
    }

    private static Map<Integer, Set<Neighbor>> createAdjacency() {
        final Map<Integer, Set<Neighbor>> adjacency = new HashMap<>();

        //This sets up the adjacencies. In this case all adjacencies have a cost of 1, but they dont need to. Otherwise
        //They are exactly the same as the example you gave in your question
        addAdjacency(adjacency, 1,2,1,5,1);         //{1 | 2,5}
        addAdjacency(adjacency, 2,1,1,3,1,4,1,5,1); //{2 | 1,3,4,5}
        addAdjacency(adjacency, 3,2,1,5,1);         //{3 | 2,5}
        addAdjacency(adjacency, 4,2,1);             //{4 | 2}
        addAdjacency(adjacency, 5,1,1,2,1,3,1);     //{5 | 1,2,3}

        return Collections.unmodifiableMap(adjacency);
    }

    private static void addAdjacency(Map<Integer, Set<Neighbor>> adjacency, int source, Integer... dests) {
        if( dests.length % 2 != 0)
            throw new IllegalArgumentException("dests must have an equal number of arguments, each pair is the id and cost for that traversal");

        final Set<Neighbor> destinations = new HashSet<>();
        for(int i = 0; i < dests.length; i+=2)
            destinations.add(new Neighbor(dests[i], dests[i+1]));
        adjacency.put(source, Collections.unmodifiableSet(destinations));
    }
}