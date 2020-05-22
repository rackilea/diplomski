int LENGTH = 3;
int longestCountBeforeDecimalPoint = 0;

for (int i=0; i<LENGTH; i++) {
    int indexOfDot = input[i].indexOf(".");

    if (longestCountBeforeDecimalPoint < indexOfDot) {
        longestCountBeforeDecimalPoint = indexOfDot;
    }
}