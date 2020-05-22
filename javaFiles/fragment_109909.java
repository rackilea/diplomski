for (int i = 0; i < myArray.length; i++){
    for(int z = i+1; z< myArray.length; z++){
        if(myArray[i][1]== myArray[z][1] && myArray[i][0] == myArray[z][0]){
            return false;
        }
    }
}
return true;
}