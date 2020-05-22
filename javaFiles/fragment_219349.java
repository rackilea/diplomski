public class Edge
{
    private int weight;
    private Vertex v1;
    private Vertex v2;

   @Override
   public boolean equals(Object o) {
   // self check
   if (this == o)
       return true;
   // null check
   if (o == null)
      return false;
   // type check and cast
   if (getClass() != o.getClass())
      return false;
   Edge e = (Edge) o;
   // field comparison
   return v1.equals(e.v1) && v2.equals(e.v2);
}