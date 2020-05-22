public static int GiveBackAverageID(Vector<DMatch> lista){

    // Creating more capacity in the constructor!
    ArrayList<CMatch> workingList = new ArrayList<CMatch>(lista.size());

    for (DMatch t : lista){
        if(workingList.get(t.imgIdx) == null){
            workingList.add(t.imgIdx, new CMatch(t.imgIdx,t.distance,1));
        }else{
            CMatch pom = workingList.get(t.imgIdx);
            pom.setSummaDist(pom.getSummaDist()+t.distance);
            pom.setCount(pom.getCount()+1);
            workingList.set(t.imgIdx, pom);
        }
    }
}