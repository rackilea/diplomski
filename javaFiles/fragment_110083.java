public abstract class Graph<T> {
   private List<List<T>> x;

   public Graph(int vertex,boolean directed) {
      adjacencyList = createListOfList();
   }

   protected abstract List<List<T>> createListOfList();
}