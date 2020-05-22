int newLength = originalLength - toDelete;
    int toChoose = newLength - 2;
    double fraction = toChoose / (originalLength -2)
    double counter = 0;
    int threshold = 1;
    int newArrayIndex = 1;
    for(int i = 1; i < originalLength-1; i++){
        **counter += fraction;**            
        if(integerValueOf(counter) == threshold){
            newArray[newArrayIndex] = originalArray[i];
            threshold++;
            **newArrayIndex++;**
        }

     }
     newArray[0] = originalArray[0];
     newArray[newArray.length-1] = originalArray[originalArray.length-1];