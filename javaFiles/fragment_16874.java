void RemoveFront(){
    if(CurrentFrontIndex == CurrentRearIndex){
        CurrentFrontIndex = -1;
        CurrentRearIndex = -1;
    }
    else if(CurrentFrontIndex >= 0)
        CurrentFrontIndex++;
    else
        //array is empty; cannot remove
}