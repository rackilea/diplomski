public class Vertex
{
    private int x;
    private int y;

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
   Vertex v = (Vertex) o;
   // field comparison
   return x == v.x && y == v.y;

}