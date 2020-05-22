void addFirst(int a){
    if(CurrentFrontIndex == -1){
        array[++CurrentFrontIndex] = a;
        CurrentRearIndex++;
    }
    else if(CurrentFrontIndex > 0)
        array[--CurrentFrontIndex] = a;
    else
        //cannot add to front
}