Map<Character, Integer> mappedValues = new HashMap<Character, Integer>();
mappedValues.put('A', 1);
mappedValues.put('B', 2);
...//and so on

String nat = "NATHAN";
Map<Character, Integer> charToInt = new HashMap<Character, Integer>();
for(int i = 0; i < nat.length(); i++){
    charToInt.put(nat.charAt(i), mappedValues.get(nat.charAt(i)));
}
//{('N', 5), ('A', 1)...}