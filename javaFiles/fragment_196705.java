int getRepeatedElements(int[] array){
    //Sort the numbers in ascending order
    java.util.Arrays.sort(array);

    //Strategy: Store the first occurrence of each number and then move to the next element to see if it is repeated
    int currentElement = array[0];
    int repeatedCount = 0;
    int i = 1;
    boolean alreadyCounted = false;

    while(i < array.length){
        if(currentElement == array[i]){
            //Found a repeated element!
            if(!alreadyCounted){
                repeatedCount++;
                alreadyCounted = true;
            }
        }
        else{
            //New element found
            currentElement = array[i];
            alreadyCounted = false;
        }
        i++; //Move to the next element
    }
    return repeatedCount;
}