int i = position - 1; 

    for(int j = position; j < pivot; j++ ) {

        if(anArray[j] <= x) {
             i = i + 1;
             swap(anArray, i, j);
        } 

    }