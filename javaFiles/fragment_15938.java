// a list which will be used to put the unique values in
List<Integer> result = new ArrayList<>();

// loop through each number in the first array
for(int i=0; i< arrayOne.length; i++){

    boolean isInOtherArray = false;
    // check this number against each number in the second array
    for(int j=0; j<arrayTwo.length; j++){

        // if the number matches, then we know its not unique 
        // so we stop the search
        if(arrayOne[i] == arrayTwo[j]){
            isInOtherArray=true;
            break;
        }
    }
    // if its not in the other array we know its unique so it goes 
    // in our result list
    if(!isInOtherArray){
        result.add(arrayOne[i]);
    }
}