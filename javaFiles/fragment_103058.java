import java.util.*;

public class myListGraph
{
    protected String[] names;   // 1-d array to store the vertices
    protected StringLinkList[] Edges;   // 1-d array to store adjacencies between vertices,
    protected int numVertices;  
    protected int numEdges;

    // Default constructor. Sets aside enough capacity for one vertex
    public myListGraph( )       
    {           
        this(1);
    }

    // Constructor that sets aside as much capacity as specified by the user
    public myListGraph(int capacity)    
    {           
        names = new String[capacity];
        Edges = new StringLinkList[capacity];
        for (int i = 0 ; i < capacity ; i ++) {
            Edges[i] = new StringLinkList();
        }

    }

    public int numberOfVertices()
    {
                 return numVertices;
        }

        public int numberOfEdges()
        {
                 return numEdges;
        }

    // Finds the location at which a vertex is stored in Vertices. 
    // Returns -1 if vertex not found
    public int getIndex(String vertex)
    {
        for(int i = 0; i < numVertices; i++)
            if(vertex.equals(names[i]))
                return i;

        return -1;
    }

    // Resizes the array of vertices. Can make it larger or smaller, depending
    // on what newSize is. 
    protected String[] resize(String[] array, int newSize)
    {
        String[] temp = new String[newSize];

        int smallerSize = newSize;
        if(array.length < smallerSize)
            smallerSize = array.length;

        for(int i = 0; i < smallerSize; i++)
            temp[i] = array[i];

        return temp;
    }

    // Resizes the array of Edges. Can make it larger or smaller, depending
    // on what newSize is. 
    protected StringLinkList[] resize (StringLinkList[] array, int newSize)
    {
        StringLinkList[] temp = new StringLinkList[newSize];

        int smallerSize = newSize;
        if(array.length < smallerSize)
            smallerSize = array.length;

        for(int i = 0; i < smallerSize; i++)
            temp[i] = array[i];

        for (int i = smallerSize ; i < temp.length ; i ++)
            temp [i] = new StringLinkList();

        return temp;
    }

    // Adds a new vertex
    public void addVertex(String newVertex)
    {
        if(getIndex(newVertex) != -1)
        {
            System.out.print("addVertex: ");
            System.out.print(newVertex);
            System.out.println(" failed -- vertex already exists.");
            return;
        }

        // if array of vertices is full, we need to expand it and 
        // also expand Edges
        if (names.length == numVertices)
        {
            names = resize(names, 2*numVertices+1);
            Edges = resize(Edges, 2*numVertices+1);
        }

        names[numVertices++] = newVertex;
    }


    // Adds a new edge
    public void addEdge(String vertex1, String vertex2)
    {
        int i = getIndex(vertex1);
        if(i == -1)
        {
            System.out.print("addEdge failed: ");
            System.out.print(vertex1);
            System.out.println(" does not exist.");
                    return;
            }

        int j = getIndex(vertex2);
        if(j == -1)
        {
            System.out.print("addEdge failed: ");
            System.out.print(vertex2);
            System.out.println(" does not exist.");
                    return;
            }

        Edges[i].insertFirst(names[j]);
        Edges[j].insertFirst(names[i]);


        numEdges++;
    }

    // Prints the neighbors of the given vertex
    public void printAdjacencyList (String vertex)
    {
        int i = getIndex(vertex);
        if(i == -1)
        {
            System.out.print("addEdge failed: ");
            System.out.print(vertex);
            System.out.println(" does not exist.");
                    return;
            }

        System.out.print (vertex + " is connected to ");
        Edges [i].displayList();        
    }


        // returns the names of all the neighbors of a given vertex in a 
    // String array
        public String[] getNeighbors(String vertex)
        {
                int source = getIndex(vertex);
                if(source == -1)
                {
                        System.out.print("getNeighbors failed: Vertex ");
                        System.out.print(vertex);
                        System.out.println(" does not exist.");
                        return null;
                }

        return Edges[source].copyIntoArray();
        }

        // returns the indices of all the neighbors of a given vertex. The
        // vertex is specified as an index and the neighbors are returned
    // in an int array 
        public int[] getNeighbors(int index)
        {
                if((index < 0) || (index >= numVertices))
                {
                        System.out.print("getNeighbors failed: Index");
                        System.out.print(index);
                        System.out.println(" is out of bounds.");
                        return null;
                }

        // Call the earlier getNeighbors function to get the names of
        // neighbors
                String[] nbrNames = getNeighbors(names[index]);

        // Turn the array of neighbor names into an array
        // of neighbor indices
        int[] nbrIndices = new int[nbrNames.length];
        for(int i = 0; i < nbrIndices.length; i++)
            nbrIndices[i] = getIndex(nbrNames[i]);

        return nbrIndices;
        }



        // returns the degree of a vertex with given name
        public int degree(String vertex)
        {
                // Get the index of the vertex
                int i = getIndex(vertex);
                if(i == -1)
                {
                        System.out.print("In degree: ");
                        System.out.print(vertex);
                        System.out.println(" does not exist.");
                        return -1;
                }

                // Call the other degree function that returns the degree
                // of a vertex, given its index
                return degree(i);
        }

        // returns the degree of a vertex with given index
        public int degree(int index)
        {
        return Edges[index].size();

        }

    // Boolean method that tells us if {v1, v2} is an edge in the graph
    public boolean isEdge(String vertex1, String vertex2)
    {
                int i = getIndex(vertex1);
                if(i == -1)
                {
                        System.out.print("isEdge failed: ");
                        System.out.print(vertex1);
                        System.out.println(" does not exist.");
                        return false;
                }

                int j = getIndex(vertex2);
                if(j == -1)
                {
                        System.out.print("isEdge failed: ");
                        System.out.print(vertex2);
                        System.out.println(" does not exist.");
                        return false;
                }

        // if vertex2 exists in the adjacency list of
        // vertex1, then return true
        return (Edges[i].find(vertex2) != null);
    }


    // Computes the clustering coefficient of a vertex. This is the
    // version that takes a vertex index as argument.
    public double clusteringCoefficient(int i)
    {

        // Copy the adjacency list into an array, for easy access
        // copyIntoArray is a new method in the GenericLinkList class
        String[] temp = Edges[i].copyIntoArray();

        // initialize edges-in-neighborhood to 0
        int edgesInNbd = 0;

        // Scan pairs of neighbors and increment counter whenever
        // there is an edge
        for(int j = 0; j < temp.length; j++)
            for(int k = 0; k < j; k++)
                if(isEdge(temp[j], temp[k]))
                    edgesInNbd++;

        // if there are no neighbors or one neighbor then, clustering 
        // coefficient is trivially defined to  be 1. Otherwise, 
        // compute the ratio of number of edges in neighborhood to 
        // the total number of pairs of neighbors
        if(temp.length <= 1)
            return 1;
        else 
            return edgesInNbd*2.0/(temp.length*(temp.length-1));

    }

        // Computes the clustering coefficient of a vertex. This is the
        // version that takes a vertex name as argument.
        public double clusteringCoefficient(String v)
        {
                int i = getIndex(v);
                if(i == -1)
                {
                        System.out.print("clusteringCoefficient failed: ");
                        System.out.print(v);
                        System.out.println(" does not exist.");
                        return 0;
                }

        return clusteringCoefficient(i);
    }

    // Computes the clustering coefficient of the entire graph
    // added on 2/23
    public double clusteringCoefficient()
    {
        double sum = 0;
        for(int i = 0; i < numVertices; i++)
            sum =  sum + clusteringCoefficient(i);

        return sum/numVertices;
    }       

    // Checks whether the graph is connected or not by calling breadthFirstSearch
    public boolean isConnected()
    {
        // Perform breadth first search
        int[] bfsTree = breadthFirstSearch(names[0]);

        // Scan the bfsTree array, looking for -1. The graph
        // is not connected if there is -1 in this array
        for(int i = 0; i < bfsTree.length; i++)
            if(bfsTree[i] == -1)
                return false;

        return true;
    }


    // Returns a 2-d array of vertex names representing the connected components
    // of the graph. Each row in the 2-d array is a connected component.
    public String[][] connectedComponents()
    {
        // The maximum number of connected components equals the number
        // of vertices; so start by allocating this many rows.
        String[][] cc = new String[numVertices][];

        // Keeps track of which vertices have been visited by repeated
        // calls to bfs
        boolean[] visited = new boolean[numVertices];
        for(int i = 0; i < numVertices; i++)
            visited[i] = false;

        // Keeps track of the number of vertices have been visited by repeated
        // calls to bfs
        int numVisited = 0;

        // Keeps track of the number of connected components
        int numComponents = 0;

        // Repeat bfs until all vertices have been visited
        while(numVisited < numVertices)
        {
            // Scan visited until an unvisited vertex is found
            // and start bfs at that source
            int source;
            for(source = 0; source < numVisited; source++)
                if(!visited[source])
                    break;

            // Compute the bfsTree starting at this source
            int[] bfsTree = breadthFirstSearch(names[source]);

            // Scan bfsTree to count number of newly visited vertices
            int countNewVisited = 0;
            for(int i = 0; i < numVertices; i++)
                if(bfsTree[i] != -1)
                    countNewVisited++;

            // Allocate a row of size countNewVisited in the current row of
            // cc to store the new connected component
            cc[numComponents] = new String[countNewVisited];

            // Scan bfsTree again, this time to copy the newly visited
            // vertices into cc and set them as visited
            countNewVisited = 0;
            for(int i = 0; i < numVertices; i++)
                if(bfsTree[i] != -1)
                {
                    cc[numComponents][countNewVisited++] = names[i];
                    visited[i] = true;
                }

            // Update numVisited    
            numVisited = numVisited + countNewVisited;

            // Update numComponents
            numComponents++;

        } // end while 

        // Resize cc to have exactly as mamy rows as numComponents
        String[][] newCC = new String[numComponents][];
        for(int i = 0; i < numComponents; i++)
            newCC[i] = cc[i];   

        return newCC;


    }

    // Computes a shortest path (in hops) from source to destination. Does
    // this by simply calling breadthFirstSearch and following the parent
    // pointers in the BFS tree. If the source and destination are not in
    // the same component, returns null. Otherwise, returns a String array
    // of vertices in a shortest path
    public String[] shortestPath(String source, String dest)
    {
        // Get index of source
        int sourceIndex = getIndex(source);
                if(sourceIndex == -1)
                {
                        System.out.print("breadthFirstSearch failed: ");
                        System.out.print(source);
                        System.out.println(" does not exist.");
                        return null;
                }

        // Get index of destination
                int destIndex = getIndex(dest);
                if(destIndex == -1)
                {
                        System.out.print("breadthFirstSearch failed: ");
                        System.out.print(dest);
                        System.out.println(" does not exist.");
                        return null;
                }

        // Perform a BFS from destination
        int[] bfsTree = breadthFirstSearch(destIndex);

        // If source is unreachable from destination
        if(bfsTree[sourceIndex] == -1)
            return null;

        // Define a String[] for shortest path and place the source vertex
        // in it
        String[] path = new String[numVertices];
        path[0] = names[sourceIndex];       

        // Start following parent pointers and store each new vertex
        // encountered, in the path array. The while-loop executes
        // until the root of the BFS tree is encountered
        int currentIndex = sourceIndex; 
        int pathLength = 0;
        while(currentIndex != bfsTree[currentIndex])
        {
            currentIndex = bfsTree[currentIndex];
            pathLength++;
            path[pathLength] = names[currentIndex];
        }

        // Resize the path array to be exactly of the correct size
        String[] newPath = new String[pathLength + 1];
        for(int i = 0; i < newPath.length; i++) 
            newPath[i] = path[i];

        return newPath;
    }

    // Breadth first search function that takes a vertex name as argument; 
    // returns  a breadth first search tree
    // stored in an array of integers with the entry in slot i containing
    // the index of the parent of the vertex with index i
    // parent of source is itself; unvisited nodes have parent -1
    public int[] breadthFirstSearch(String source)
    {
            int sourceIndex = getIndex(source);
                if(sourceIndex == -1)
                {
                        System.out.print("breadthFirstSearch failed: ");
                        System.out.print(source);
                        System.out.println(" does not exist.");
                        return null;
                }

        return breadthFirstSearch(sourceIndex);
    }


    // Breadth first search function that takes a vertex index as argument; 
    // returns  a breadth first search tree
    // stored in an array of integers with the entry in slot i containing
    // the index of the parent of the vertex with index i
    // parent of source is itself; unvisited nodes have parent -1
    public int[] breadthFirstSearch(int sourceIndex)
    {
        // Initialize the bfsTree array; the entry -1 means
        // not yet visited.
        int[] bfsTree = new int[numVertices];
        for(int i = 0; i < numVertices; i++)
            bfsTree[i] = -1;

        // The parent of the tree root is itself
        bfsTree[sourceIndex] = sourceIndex;

        // Then initialize the visited array
        boolean[] visited = new boolean[numVertices];
        for(int i = 0; i < numVertices; i++)
            visited[i] = false;

        visited[sourceIndex] = true;

        // Then initialize the queue
        Queue Q = new Queue(numVertices);
        Q.enqueue(sourceIndex);

        while(!Q.isEmpty())
        {
            // get the index of the vertex first in line
            int current = Q.dequeue();

            // Get the indices of the neighbors of the current vertex
            int[] neighbors = getNeighbors(current);

            // Scan the neighbors
            for(int i = 0; i < neighbors.length; i++)
            {
                // Get the index of the current neighbor
                int currentNeighbor = neighbors[i];

                // Check if the neighbor is new, i.e., not visited
                // If so, mark the neighbor as visited, enqueue the neighbor, and 
                // set the neighbor's parent in bfsTree
                if(!visited[currentNeighbor])
                {
                    visited[currentNeighbor] = true;
                    Q.enqueue(currentNeighbor);
                    bfsTree[currentNeighbor] = current;
                }

            } // end-scanning neighbors

        } // end-while Q is not empty

        return bfsTree;

    }   


} // end of class