TreeMap<Character, Integer> map = new TreeMap<>();
String input = "abcaaaabbzzzzz".toUpperCase();
String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

for (int i=0; i < input.length(); ++i) {
    Integer val = map.get(input.charAt(i));
    map.put(input.charAt(i), val == null ? 1 : val + 1);
}
Collection<Integer> c = map.values();
int maxFrequency = Collections.max(c);

System.out.println("Input:\n" + input);
for (int i=maxFrequency; i > 0; --i) {
    for (int j=0; j < alphabet.length(); ++j) {
        Integer count = map.get(alphabet.charAt(j));
        System.out.print((count != null && count >= i) ? "*" : " ");
    }
    System.out.println();
}
System.out.println(alphabet);