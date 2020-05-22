for(int i: array1){
    boolean found = false;
    for(int j: array2){
       if(i==j){
          found = true;
       }
    }
    if(!found){
       returnArray.add(i);
    }
}