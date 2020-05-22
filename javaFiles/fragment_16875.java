void RemoveRead(){
    if(CurrentRearIndex == CurrentFrontIndex){
        CurrentRearIndex = -1;
        CurrentFrontIndex = -1;
    }
    else if(CurrentRearIndex <= array.length)
        CurrentRearIndex--;
    else
        //array is empty; cannot remove
}