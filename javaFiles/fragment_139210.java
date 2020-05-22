public boolean isSortedDescendant(int [] array){
    if ((array.length == 0) || (array.length == 1)) {
        return true;
    } else {
        for(int i = 0; i < array.length - 1; i++){
            if (array[i] <= array[i + 1]) {
                return false;
            }
        }
        return true;
    }
}