int count = 0; //initialize count
for(int i = 0; i < arrayname.length; i++){
    if(arrayname[i] > 12){
        count++; //iterate original array, getting number of integers greater than 12
    }
}


int[] newarray = [count]; //initialize new array to this number
count = 0; //reinitialize count to begin at first element in new array
for(int i = 0; i < arrayname.length; i++){
    if(arrayname[i] > 12){
        newarray[count] = arrayname[i]; //set each element >12 in original to next element in new array
        count++; //move through new array
    }
}