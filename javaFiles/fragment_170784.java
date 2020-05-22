public class Originator<V,E> {
    private Graph<V,E> graph;
    private Caretaker caretaker;

    public Originator(Caretaker caretaker) {
      this.graph = new GraphEdgeList();
      this.caretaker = caretaker;
    }

    public Originator(Originator<V, E> originator) {
         this.graph = new GraphEdgeList((GraphEdgeList) originator.getGraph());
         this.caretaker = originator.getCaretaker();
    }

    public Memento createMemento() {//create new memento
        return new Memento(new Originator(this));
    }

    public void setMemento(Memento memento) {//set memento
       graph = memento.getGraph();
    }

    public Graph getGraph() {
      return graph;
    }

    public Caretaker getCaretaker() {
     return caretaker;
    }
}