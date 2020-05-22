public List<B> castAList(List<A> aList){

    List<B> bList = new ArrayList<>();

    for(A a : aList){
       bList.add((B) a);
    }

    return bList;
}