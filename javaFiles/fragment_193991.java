// This is `double-braces` initialization. 
// You can rather initialize your Map in a way you are comfortable with
Map<Character, Integer> vowels = new HashMap<Character, Integer>() {
    {
        put('a', 0);
        put('e', 0);
        put('i', 0);
        put('o', 0);
        put('u', 0);
    }
}; // Note the semi-colon here