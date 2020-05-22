for(int i = A.length - 1; i >= 0; i--) {
    sumPerCol = A[i] + B[i] + carriedValue;             
    if(sumPerCol >= 10) { 
        carriedValue = sumPerCol / 10;
        totalArray[i+1] = sumPerCol % 10;
    } else {
        totalArray[i+1] = sumPerCol;
        carriedValue = 0;
    }
}// end of for-Loop 
totalArray[0] = carriedValue;