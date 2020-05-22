public class Graph
{
    Map<String, LinkedList<String>> adj;

    public Graph() {
        adj = new HashMap<String, LinkedList<String>>();
    }

    public void addNode(String node) 
    {
        adj.putIfAbsent(node, new LinkedList<String>());
    }

    public void addNeighbor(String v1,String v2) {
       adj.get(v1).add(v2);
    }

    public List<String> getNeighbors(String v) {
       return adj.get(v);
    }

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        File file = new File("city.txt");
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line;
        String [] tokens;

        Graph g = new Graph();
        while( (line = br.readLine()) != null )
        {
           tokens = line.split("\\s+");
           g.addNode( tokens[0]);
           g.addNode( tokens[1]);
           g.addNeighbor( tokens[0], tokens[1]);
        }
        br.close();
     }
}