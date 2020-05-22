import java.util.ArrayList;
import java.util.HashMap;

public class AdjacencyListDemo {

    static int availableId=0;                            //Represents the available id for mapping
    static HashMap<String,Integer> mapping;              //To store the String-Integer mapping for Vertexes
    static ArrayList<ArrayList<Integer>> adjacencyList;

    public static void main(String args[])
    {
        adjacencyList = new ArrayList<ArrayList<Integer>>();

        mapping  = new HashMap<String,Integer>();

        String sampleVertexes[] = {"Vertex1","Vertex2","Vertex3","Vertex4"};

        for(String vertex : sampleVertexes)
            addNewVertex(vertex);

        addEdgeBetween("Vertex1","Vertex2");
        addEdgeBetween("Vertex3","Vertex4");

        System.out.println("Old List: ");
        printList();

        //Add New Vertex if required
        addNewVertex("Vertex5");

        addEdgeBetween("Vertex5","Vertex1");
        addEdgeBetween("Vertex2","Vertex1");
        addEdgeBetween("Vertex3","Vertex2");
        addEdgeBetween("Vertex5","Vertex2");

        System.out.println("\n\nNew List: ");
        printList();

    }

    private static void printList()
    {
        for(String vertex : mapping.keySet()) {
            int index = mapping.get(vertex);
            System.out.println(vertex+" ID: "+index+" List: "+adjacencyList.get(index));
        }
    }
    private static void addEdgeBetween(String vertex1, String vertex2) {
        //get both indexes
        int index1 = mapping.get(vertex1);
        int index2 = mapping.get(vertex2);

        //add index2 into the arraylist of index1 
        adjacencyList.get(index1).add(index2);
    }

    private static void addNewVertex(String vertex) {

        if(!mapping.containsKey(vertex))
        {  
            //assign available ID
            mapping.put(vertex,availableId);
            availableId++;                                   //make increment in available id
            adjacencyList.add(new ArrayList<Integer>());     //Add an Empty ArrayList
        }
    }
}