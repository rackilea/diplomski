private void fillIn (ArrayList<BufferedImage> b, ArrayList <Integer> r){
    Random rand = new Random();
    for (int i=0; i<FULLGRIDSIZE; i++){
        for (int j=0; j<FULLGRIDSIZE; j++){
            if (mapArray[i][j] ==null){
                // Random rand = new Random(); Don't create so many Randoms!
                int random = rand.nextInt(100);
                for (int loopVar =0 ;loopVar<r.size();loopVar++){
                    // System.out.println(random +" "+ loopVar);
                    // printlns take a surprisingly long time
                    if (random < r.get(loopVar)){
                        mapArray[i][j] = b.get(loopVar);
                        break;
                    }
                }                   
            }
        }
    }
}