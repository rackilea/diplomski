public int getRoundTripCost(int leave, int return_time){
    int cost = 0;
    cost = (return_time - leave) * 100;
    return cost;


} //end getRoundtrip