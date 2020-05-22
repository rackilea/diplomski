import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DijkstraAdjacencyMatrix {

    public static void main(String[] args) {

        Set<CityNode> cities = new HashSet<>();
        CityNode a = new CityNode("A");
        CityNode b = new CityNode("B");
        CityNode c = new CityNode("C");
        CityNode d = new CityNode("D");
        CityNode e = new CityNode("E");
        cities.addAll(List.of(a,b,c,d,e));

        CitiesGraph graph = new CitiesGraph(cities);
        graph.connectCities(a, b, 50);
        graph.connectCities(b, c, 30);
        graph.connectCities(c, d, 40);
        graph.connectCities(d, e, 20);
        graph.show();

        FindPath findPath = new FindPath();
        System.out.println(findPath.calculateShortestPath(graph, a, e)); //prints 140 as expected

        //to add some complexity we need to construct a new CitiesGraph. It is not reusable
        CityNode f = new CityNode("F");
        cities.add(f);
        graph = new CitiesGraph(cities);
        graph.connectCities(a, b, 50);
        graph.connectCities(b, c, 30);
        graph.connectCities(c, d, 40);
        graph.connectCities(d, e, 20);
        graph.connectCities(b, f, 10);
        graph.connectCities(f, d, 10);
        graph.show();
        System.out.println(findPath.calculateShortestPath(graph, a, e));//prints 90 as expected
    }
}

class FindPath{

    //map to hold distances of all node from origin. at the end this map should contain
    //the shortest distance between origin (from) to all other nodes
    Map<CityNode, Integer> distances;

    //using Dijkstra algorithm
    public int calculateShortestPath(CitiesGraph graph, CityNode from, CityNode to) {

        //a container to hold which cities the algorithm has visited
        Set<CityNode> settledCities = new HashSet<>();
        //a container to hold which cities the algorithm has to visit
        Set<CityNode> unsettledCities = new HashSet<>();
        unsettledCities.add(from);

        //map to hold distances of all node from origin. at the end this map should contain
        //the shortest distance between origin (from) to all other nodes
        distances = new HashMap<>();
        //initialize map with values: 0 distance to origin, infinite distance to all others
        //infinite means no connection between nodes
        for(CityNode city :graph.getCities()){
            int distance = city.equals(from) ? 0 : Integer.MAX_VALUE;
            distances.put(city, distance);
        }

        while (unsettledCities.size() != 0) {
            //get the unvisited city with the lowest distance
            CityNode currentCity = getLowestDistanceCity(unsettledCities);
            //remove from unvisited, add to visited
            unsettledCities.remove(currentCity); settledCities.add(currentCity);

            Collection<CityNode> connectedCities = graph.getCitiesConnectedTo(currentCity);
            //iterate over connected city to update distance to each
            for( CityNode city : connectedCities){
                //check if new distance is shorted than the previously found distance
                int distanceToCity = graph.getDistanceBetween(city, currentCity);
                if(distanceToCity <= 0) {
                    continue;
                }
                if(distances.get(currentCity) + distanceToCity < distances.get(city)){
                    //if so, keep the shortest distance found
                    distances.put(city,distances.get(currentCity) + distanceToCity);
                    //if city has not been visited yet, add it to unsettledCities
                    if(! settledCities.contains(city)) {
                        unsettledCities.add(city);
                    }
                }
            }
        }

        return distances.get(to);
    }

    private CityNode getLowestDistanceCity(Set <CityNode> unsettledCities) {

        return unsettledCities.stream()
                 .min((c1,c2)-> Integer.compare(distances.get(c1), distances.get(c2)))
                 .orElse(null);
    }
}

class CityNode {

    private static int counter =0;
    private final String name;
    //assign unique id to each node. safer than to rely on unique name
    private final int id = counter ++;

    public CityNode(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("City ");
        sb.append(name).append(" (id=").append(id).append(")");
        return sb.toString();
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {

        if(o == null || !(o instanceof CityNode)) return false;

        CityNode c = (CityNode) o;
        return c.getName().equalsIgnoreCase(name) && id == c.getId();
    }

    @Override
    public int hashCode() {
        int hash = 31 * 7 + id;
        return name == null ? hash : name.hashCode();
    }
}

class CitiesGraph{

    //use set which prevents duplicate entries
    private final Set<CityNode> cities;
    private final int[][] adjacencyMatrix;
    private static final int NOT_CONNECTED = -1;

    public  CitiesGraph(Set<CityNode> cities) {
        this.cities = cities;
        adjacencyMatrix = new int[cities.size()][cities.size()];
        //initialize matrix
        for(int row = 0; row < adjacencyMatrix.length ; row++){
            for(int col = 0; col < adjacencyMatrix[row].length ; col++){
                adjacencyMatrix[row][col] = row == col ? 0 : NOT_CONNECTED ;
            }
        }
    }

    public void connectCities(CityNode city1, CityNode city2, int distance) {
        //assuming undirected graph
        adjacencyMatrix[city1.getId()][city2.getId()] = distance;
        adjacencyMatrix[city2.getId()][city1.getId()] = distance;
    }

    public int getDistanceBetween(CityNode city1, CityNode city2) {

        return adjacencyMatrix[city1.getId()][city2.getId()];
    }

    public Collection<CityNode> getCitiesConnectedTo(CityNode city) {

        Collection<CityNode> connectedCities = new ArrayList<>();
        //iterate over row representing city's connections
        int column = 0;
        for(int distance : adjacencyMatrix[city.getId()]){
            if(distance != NOT_CONNECTED && distance > 0) {
                connectedCities.add(getCityById(column));
            }
            column++;
        }

        return connectedCities;
    }

    public CityNode getCityById(int id) {
        for (CityNode city : cities) {
            if (city.getId() == id) return city;
        }
        return null;
    }

    public void show() {
        for(int[] row : adjacencyMatrix){
            System.out.println(Arrays.toString(row));
        }
    }

    //get a copy of cities list
    public Collection<CityNode> getCities(){
        return new ArrayList<>(cities);
    }
}