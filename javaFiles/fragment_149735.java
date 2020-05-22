boolean foundDot = false;
for (int i = 0; i < arr.length; i++) {
    if(arr[i] == '.') {
        foundDot = true;
    } else if(foundDot) {
        numDecimalDigits ++;
    }
}