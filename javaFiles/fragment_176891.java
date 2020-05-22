while (i+j < array.length && r){
    if(array[i]<array[i+j]){
        if(i+j == numElements){
            result = array[i];
            r = false;
        }
        ++j;
    }
    else{
        i += j;
        j = 1;
    }
}