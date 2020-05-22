public static String[] mySplit(String input){
    int len = input.length(), index = 0;

    // Arrays are faster than lists
    String[] array = new String[len/2+len%2];
    for (int i = 0; i < len-1; i+=2, index++) {
        array[index]=input.substring(i,i+2);
    }
    // To handle strings with an odd number of characters
    if(input.length()%2==1) {
        array[index]=input.substring(input.length()-1);
    }
    return array;
}