class State{
   String name;
   List list;
   public State(String name, List list){
        this.list = list;
        this.name = name;
   }
}

class main{
   private TreeMap treeMap = new TreeMap();
   private String newState = "whatever identifier you like";
   ArrayList setState = new ArrayList();
   State startState = new State(newState, setState);

   treeMap.put(startState.name, startState); // now the State-Instance startState can be referenced via 
                                             // the String newState. The reference to the corresponding 
                                             // ArrayList is within the state object

}