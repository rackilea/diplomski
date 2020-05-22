public String wordsToCorrect (String word)
{
    StringBuilder sb;
    String[] bro =new String[5];
    bro [0] = "bros";
    bro [1] = "bro";
    bro [2] = "bros";
    bro [3] = "broda";
    bro [4] = "brother";
    String[] brother = bro;
    String[] si = new String[6];
    si [0] = "sis";
    si [1] = "sister";
    si [2] = "sista";
    si [3] = "6sta";
    si [4] = "sisy";
    si [5] = "sissy";

    List<String> broList = Arrays.asList(bro);
    List<String> sisList = Arrays.asList(si);
    String[] words = word.split("\\s");
    for(int i=0; i<words.length; i++){
        String singleWord = words[i];
        if(broList.contains(singleWord.toLowerCase())){
            words[i] = "brother";
        }else if(sisList.contains(singleWord.toLowerCase())){
            words[i] = "sister";
        }
    }
    return String.join(" ", words);
}