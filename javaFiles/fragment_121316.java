public void runDistance(int x, int y, int n) {
    int distanceRun = 0;
    int elevation = 0;


    //Takes us to one run shy of the top of the hill
    while(elevation+(x) < n) {
        elevation+=(x-y);
        distanceRun+=x+y;
    }


    //adds the last bit of distance to the top of the hill (since we won't be running back down again)
    //We don't want to add the full x distance because that might be more than the hill. We just want to add what's left.
    if(elevation < n) {
        distanceRun+=(n-elevation);
    }


    System.out.println("Total distance run: " + distanceRun);


}