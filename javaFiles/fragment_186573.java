public List<SomeTOs> pruneList(List<SomeTOs> unpruned,int expectedLength){
    List<SomeTOs> rtVl = new ArrayList<SomeTOs>();
    for (int i = 0; i < unpruned.length && expectedLength; ++i){
         rtVl.add(unpruned.get(i);
    }
    return rtVl;
}