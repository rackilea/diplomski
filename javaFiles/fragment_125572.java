public static void main(String[] args) {
    String word = "a bit of words";
    System.out.println(test(word));
}

public static String test(String sentence){
    if(sentence.length() <= 1){
        return sentence;
    } else {
        String newWord = "";
        return newWord += test(sentence.substring(0, sentence.indexOf(" "))) + " N ";
    }
}