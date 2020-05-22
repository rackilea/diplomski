public static String removeAllChars(String src, String dst){
    HashSet<Character> chars = new HashSet<>();
    char[] dstCharArray=dst.toCharArray();
    for (int i=0; i<dstCharArray.length; i++){
        chars.add(dstCharArray[i]);
    }
    StringBuilder sb = new StringBuilder();
    char[] srcCharArray = src.toCharArray();
    for (int i=0; i<srcCharArray.length; i++){
        if (!chars.contains(srcCharArray[i])){
            sb.append(srcCharArray[i]);
        }
    }
    return sb.toString();

}