String phrase = "aa";
String s = "sdaaf fd hgfaaf ghjfada dgffaasdf";  
String[] words = s.split(" ");  
List<String> wordList = new ArrayList<String>();
for(String word : words)  
{  
    if(word.contains(phrase))
    {
       wordList.add(word);
    }  
]