class Vertex<V, R extends Vertex<V, R>>
  {
    protected List<R> neighbours = new ArrayList<>();

    public List<R> getAdjList()
    {
      return neighbours;
    }
  }

  public abstract class GraphClass<V extends Vertex<?,?>,E extends Edge<V,?>> implements UndirectedGraph<V,E>
  {
    public abstract List<? extends V> getNeighbors(V v);
  }

  public class KVertex extends Vertex<Integer, KVertex>
  {

  }


  public class KTree extends GraphClass<KVertex,KEdge>
  {
    @Override
    public List<KVertex> getNeighbors(KVertex v)
    {
       return v.getAdjList();
    }
  }