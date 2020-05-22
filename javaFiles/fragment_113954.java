public static void main(String args[]) {
    String str = "AbrAcadAbRa";
    int length = 4;
    String subString = "";
    // iterate over the length of the input, offset by the substring length
    for (int i = 0; i < str.length()-length+1; i++) {
        subString = str.substring(i, i+length);
        System.out.println(subString);
        // this is wrong; don't modify the original string
        //str = str.substring(i);
    }
}