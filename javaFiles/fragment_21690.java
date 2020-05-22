for (int i = 0 ; i < numberArray.length ; i++) {
    if (numberArray[i]==x)
        return i;
}
// If we are here, we did not find anything; return -1
return -1;