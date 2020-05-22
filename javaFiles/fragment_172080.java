String str = "abcde";

Map<Character, Integer> charMap = new HashMap<Character, Integer>();// value of character
charMap.put('a', 1);
charMap.put('b', 2);
charMap.put('c', 3);
charMap.put('d', 4);
charMap.put('e', 5);
// put more entry for rest of the characters

Map<Character, Integer>  jumblMap = new HashMap<Character, Integer>();// value to add
jumblMap.put('a', 3);    
jumblMap.put('b', -1);
jumblMap.put('c', 2);
jumblMap.put('d', 5);
jumblMap.put('e', -3);
// put more entry for rest of the characters

char c = str.charAt(0);
int val = charMap.get(c);// No jumble value for first character
System.out.print(val + " ");
char prevC;
for(int i = 1; i < str.length(); i++) {
  c = str.charAt(i);
  prevC = str.charAt(i - 1);// previous character
  val = charMap.get(c) + jumblMap.get(prevC);// evaluate with jumble value of previous char
  System.out.print(val + " ");
}