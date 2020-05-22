for (Map.Entry<String, ArrayList<String>> entry : adjList.entrySet()) {
    String key = entry.getKey();
    ArrayList<String> values = new ArrayList<>(); // Wrong place for this variable.
    values.add(key);
    ArrayList<String> value = entry.getValue();    
    for(String v:value){
        if(tGraph.containsKey(v)){
            values.addAll(tGraph.get(v));
        }
        tGraph.put(v, values);
    }
}