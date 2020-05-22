String[] words = {"GAGGAG", "AGGAC"};
String sentence = "GAGGAGGTC";
if(checkContainsAll(sentence, words)) {
    System.out.println("The sentence " + sentence + " contains all words");
} else {
    System.out.println("The sentence " + sentence +" does not contain all words.");
}