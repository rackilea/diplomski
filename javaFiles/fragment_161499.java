Map<Character, Integer> word_count_1 = createMap(); // initialize with a:0, b:0, c:0,...z:0
Map<Character, Integer> word_count_2 = createMap(); // initialize with a:0, b:0, c:0,...z:0<Character, Integer>

int count, value;

for (int i=0; i<word1.length(); i++)
{
    if (word1.charAt(i) != word2.charAt(i))
    {
        value = word_count_1.get(word1.charAt(i));
        word_count_1.put(word1.charAt(i), ++value);

        value= word_count_2.get(word2.charAt(i));
        word_count_2.put(word2.charAt(i), ++value);
    }
}

Set set = word_count_2.entrySet();
for(<Map.Entry<Character, Integer>> iter:set) 
{
    if ( (iter.getValue() > 0) && (word_count_1.get(iter.getKey())) > 0 )
    {
        count++; // This line has a bug. We shall ignore it for now
    }
}