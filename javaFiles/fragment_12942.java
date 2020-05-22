for(int i = 0; i < array.length; i++) {
    for(int j = 0; j < array.length; j++) {
        if(array[i] == array[j]) {
           // "i" would be a duplicate...
           break;
        }
    }
}