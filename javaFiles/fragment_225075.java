HashMap<Integer, ArrayList<Integer>> graph = new HashMap<Integer, ArrayList<Integer>>();
for (int i = 0; i < 100; i++) {
    graph.put(i, new ArrayList<Integer>());
}

int v = 0; // change value to whatever
int u = 0;
ArrayList<Integer> list = new ArrayList<Integer>(graph.get(v));
for(Integer i : list){
    if(graph.get(i).contains(v)){
        graph.get(i).remove(new Integer(v));
        graph.get(i).add(u);
    }
}