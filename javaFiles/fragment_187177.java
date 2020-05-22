/* 
 *   This class implements generic methods about polygon, like size, area and 
 *   so on, leveraging on the Vertex2D iterator.
 */
public abstract class SimplePolygon implements Polygon {

    // all concrete subclasses must implement iterator
    public abstract Iterator<Vertex2D> iterator();

    // this generic method prints the vertex list
    // using iterator hides the data structure used in implementation
    public String toString() {
       Iterator<Vertex2D> it = iterator();
       if (! it.hasNext())
           return "[]";

       StringBuilder sb = new StringBuilder();
       sb.append('Polygon: vertices = [');
       for (;;) {
           Vertex2D e = it.next();
           if (! it.hasNext())
               return sb.append("]").toString();
           sb.append(' ');
       }
    }
}

// for instance this concrete classes uses an ArrayList
public ArrayPolygon extends SimplePolygon {

    public Iterator<Vertex2D> iterator() {
       return new .....
    }
}