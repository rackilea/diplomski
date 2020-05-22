public class Node
{
   private final Node otherNode;

   public Node(Node other)
   {
      otherNode = other;
   }

   public Node()
   {
      otherNode = new Node(this);
   }

   public Node getOther()
   {
      return otherNode;
   }
}