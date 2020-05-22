public class Edge
{

   public Edge(Node start, Node end, decimal weight)
   {
      StartNode = ...,...,...
   }
   public Node StartNode;
   public Node EndNode;
   public decimal weight;
   public bool IsDirected;
}

public class Node
{
   public Node(int index)
   {
        this.Index = index;
   }
   public int Index;
   public List<Edge> Edges = new List<Edge>();
   public bool Visited = false;
}