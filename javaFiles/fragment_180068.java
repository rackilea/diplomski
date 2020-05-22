private Map<String,Integer> findClosest(Route tempRoute, List<ITSPoI> allowedPoIs, List<ITSPoI> tabulist) {  
    double cost,mincost = 999999999; 
    Map<String,Integer> closest = new HashMap<String,Integer>();

           Iterator<ITSPoI> iter;

    for (int i=0; i<tempRoute.getPOIs().size(); i++)        {
        int k = 0;

        iter = allowedPoIs.iterator();

        while(iter.hasNext()){
            ITSPoI allowedPoi = iter.next();
            if (!intabu(allowedPoi,tabulist))
            {
                try 
                {
                    cost = _cvrtw.getCostMatrix().getCost(tempRoute.getPOI(i).getNodeId(),allowedPoi.getNodeId());

                    if (cost<mincost){
                        mincost = cost;
                        closest.put("index",i);
                        closest.put("poi",k);                           
                        iter.remove(); // fix
                    }
                } 
                catch (Exception e) 
                {
                    e.printStackTrace();
                }
            }
            k++; 
        }       

    }
    return closest; 
}