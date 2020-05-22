String [] words = line.split(" ");

Map<String,Integer> frequency = new HashMap<String,Integer>();

for (String word:words){

    Integer f = frequency.get(word);
    //checking null
    if(f==null) f=0;
    frequency.put(word,f+1);
}