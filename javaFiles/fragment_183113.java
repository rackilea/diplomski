Object obj = document.getFeatures().get("MatchesAnnots");

@SuppressWarnings("unchecked")
Map<String, List<List<Integer>>> map = (Map<String, List<List<Integer>>>) obj;

for (Entry<String, List<List<Integer>>> e : map.entrySet()) {
    System.err.println("as name: "+  e.getKey());
    for (List<Integer> chain : e.getValue()) {
        System.err.println("chain : "+  chain);         
    }
}