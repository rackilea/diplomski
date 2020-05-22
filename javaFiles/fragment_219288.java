public int searchHits(String target, String aften){ // TODO

    int index = 0;
    int occurrences = 0;

    while(index != -1){

        index = aften.indexOf(target,index); // start search from index 0

        if(index != -1){
            occurrences ++; //if found, increment the counter
            index += target.length(); // set the next starting index to be after this current index
        }
    }
    return occurrences;
}