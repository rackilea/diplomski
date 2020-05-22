List<String> list = new ArrayList<>();
private void visitNextNode(int pass, int maximumPass, char[][] arr, int currI, int currJ, String value){
    //Handle blank array value condition and array out of bound expception
    value +=   arr[currI][currJ];
    if(pass == maximumPass){
        list.add(value);
        return;
    }
    //Move left 
    visitNextNode(++pass, maximumPass,arr,currI-1,currJ,value);
    //Move right
    visitNextNode(++pass, maximumPass,arr,currI+1,currJ,value);
    //Move top
    visitNextNode(++pass, maximumPass,arr,currI,currJ-1,value);
    //Move down
    visitNextNode(++pass, maximumPass,arr,currI,currJ+1,value);

}