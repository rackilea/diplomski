void addRear(int a){
    if(CurrentRearIndex == -1){
        array[++CurrentRearIndex] = a;
        CurrentFrontIndex++;
    }
    else if(CurrentRearIndex < array.length - 1)
        array[++CurrentRearIndex] = a;
    else
        //cannot at to rear
}