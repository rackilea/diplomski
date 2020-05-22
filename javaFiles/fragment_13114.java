public String convertToBinary(String str){
    char [] array = str.toCharArray();
    String binaryToBeReturned = "";

    for(int i=0;i<str.length();i++){
        binaryToBeReturned += Integer.toBinaryString((int)array[i]) + " ";
    }

    return binaryToBeReturned;

}