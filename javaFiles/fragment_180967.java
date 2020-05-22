public static String replaceSequence(String primary, String secondary, String sequence){

    Pattern pattern = Pattern.compile(sequence + "+");
    Matcher matcher = pattern.matcher(primary);

    int counter = 0;
    char [] charArray = primary.toCharArray();

    while(matcher.find() && counter<secondary.length()){
        for(int i = matcher.start(); i<matcher.end(); i++){
            charArray[i] = secondary.charAt(counter++);
            if(counter>=secondary.length()) break;
        }
    }
    return new String(charArray);
}