String[] sortArrayOfStrings(String[] array){
    int length = array.length;
    String value;
    int index;

    for(int a = 1; a < length; a++){
        value = array[a];
        index = a;
        while(index > 0 && isSmallerThan(value, array[index-1])) {
            array[index] = array[index - 1];
            --index;
        }
        array[index] = value;
    }
    return array;
}

boolean isSmallerThan(String left, String right) {
    int curIndex = 0;
    while (curIndex < left.length()
            && curIndex < right.length()
            && left.charAt(curIndex) == right.charAt(curIndex)){
        ++curIndex;
    }

    if (curIndex == left.length() || curIndex == right.length())
        return left.length() < right.length();
    else
        return left.charAt(curIndex) < right.charAt(curIndex);
}