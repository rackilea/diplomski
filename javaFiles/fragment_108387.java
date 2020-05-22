int[] myArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    int[] resultArray = new int[myArray.length];
    int oddPos = 0;
    int evenPos = myArray.length - 1;

    for(int i = 0; i < myArray.length; i++){
        if(myArray[i] % 2 == 0){
            resultArray[evenPos] = myArray[i];
            evenPos--;
        }
        else{
            resultArray[oddPos] = myArray[i];
            oddPos++;
        }
    }