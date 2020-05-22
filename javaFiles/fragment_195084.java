if(7<= 4){ // this is obviously false, so it uses the else
    colonySize *= 2;
    feedTimes--;
    breedTimes--; 
    return 1;
 } else{
    //Since this is run, and both are decremented togeather, you will always be in the Else.
    feedTimes--;
    breedTimes--;
    return 0;
 }