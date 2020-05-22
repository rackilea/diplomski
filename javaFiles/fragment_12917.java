lettercount = new HashMap<Character, Integer>();
for (int i = 0; i < str.length(); i++) {
    char c = str.charAt(i);                 
    if (Character.isLetter(c)){
        if(lettercount.containsKey(c)){       
            lettercount.get(c)++;                         
        }else
            lettercount.put(c,1);                            
    }                          
}
// here we find the max occurances
int maxCount = 0;
for(Integer count: lettercount.values())
    if (count > maxCount) maxCount = count;
// now we find the entries that had that many occurances
String characters = "";
for (Entry<Character, Integer> entry: lettercount.entrySet()) {
    if (entry.getValue().equals(maxCount))
        characters += entry.getKey();
}