String words[] = str.replaceAll("," , "").split(" ");

Set set = new HashSet();
for(String wordL : words){
    StringBuilder sb = new StringBuilder(wordL);
    if(sb.reverse().toString().equals(wordL)){
        set.add(wordL); 
    }