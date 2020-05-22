public static String compareBits(String oct, String oct2) {
    String comparison = "";
    for(int i=0; i<=oct.length()-1; i++) {
        if(oct.charAt(i) == oct2.charAt(i) && oct.charAt(i) != '0') {
            comparison = comparison+"1";
        } else {
            comparison = comparison+"0";
        }
    }

    return comparison;
}