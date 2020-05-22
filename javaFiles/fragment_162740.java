for(int i =0 ;i < m ; i++) {
    List<Integer> t = q.subList(j, k);
    List<Integer> copyOfSubList = new ArrayList<> (t);
    t.clear ();
    q.addAll(0, copyOfSubList);    
}