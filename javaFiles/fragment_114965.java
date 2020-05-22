if (!ptList.containsKey(pattern)) {
     location=new ArrayList<>();
     Triples triples = new Triples(sequenceID, i, j);
     location.add(triples);
}else{
    location=new ArrayList<>();
    Triples triples = new Triples(sequenceID, i, j);
    ptList.get(pattern).add(triples);
}