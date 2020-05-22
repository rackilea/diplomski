int[] arrayNeg = new int[counterNeg];
int[] arrayPoz = new int[counterPoz];
int arrayNegCounter = 0;
int arrayPozCounter = 0;

for (int j = 0; j < array.length; j++) {
    if (array[j] < 0){
        arrayNeg[arrayNegCounter] = array[j];
        arrayNegCounter++;
    } else if (array[j] > 0){
        arrayPoz[arrayPozCounter] = array[j];
        arrayPozCounter++;
    } else {
        continue;
    }
}