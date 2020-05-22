HashMap<Integer, ArrayList<Integer>> graph = new HashMap<Integer, ArrayList<Integer>>();
for (int i = 0; i < 100; i++) {
    graph.put(i, new ArrayList<Integer>());
}

int i = 0; // change value to whatever
int v = 0; // change value to whatever
if (graph.get(v).contains(i)) {
    graph.get(i).remove(new Integer(v));
}