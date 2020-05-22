public static int GiveBackAverageID(Vector<DMatch> lista){

    ArrayList<CMatch> workingList = new ArrayList<CMatch>();

    for (DMatch t : lista){
        if(t.imgIdx >= workingList.size() || t.imgIdx < 0)
        {
            // do something with wrong indices.
        }
        else
        {
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
}