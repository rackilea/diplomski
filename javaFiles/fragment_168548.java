private static int countZerosRec(int input ,int count){
    if (input <= 0) { // check if input is negative or zero
        return count;
    }

    int m = input % 10;
    input = input / 10;

    if (m == 0) {
        count++; // increment if current digit is zero
    }

    return countZerosRec(input,count); 
}