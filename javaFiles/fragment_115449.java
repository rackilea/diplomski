SomeType currentValue, maximumValue;

//Encapsulate currentValue and maximumValue
void setValue(SomeType value){
    currentValue = value;

    //update the maximum
    if(value.compareTo(maximumValue) > 0)
        maximumValue = value;
}

SomeType getMaximum(){
    return maximumValue;
}

SomeType getCurrent(){
    return currentValue;
}