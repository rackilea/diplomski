String fullText="Stackoverflow is the best and stackoverflow.com rocks !!!";
String [] strWords = fullText.split("\\s");
for(String strWord:strWords){
    if(strWord.contains("overflow")){
        System.out.println(strWord);
        break;
    }
}