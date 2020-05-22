int[] arrayOfNumbers = new int[arraySize];                  
for (int i=0; i < arraySize; i++){


    String w = s.substring(x,y);

    arrayOfNumbers[i] = Integer.parseInt(w); //THIS LINE IS FAILING *********

    if(i == arraySize - 2){
        x = x + 9;
        y = y + (numSize % 9);
    }
    else{
        y = y + 9;
        x = x + 9;
    }
}