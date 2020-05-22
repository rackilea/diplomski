public void members(int mNr){
    if(arraySize < memberNr.length){
        throw new IllegalArgumentException("There are no more spots available");
    } 
    //You need to loop through your array and throw exception if the incoming value mNr already present
    for(int i=0; i<memberNr.length; i++){
       if(memberNr[i] == mNr){
         throw new IllegalArgumentException("The member is already in the system");
        }
     }
    //Otherwise just add it
     memberNr[count++] = mNr;
}