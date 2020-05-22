List<String> words = new ArrayList<String>();
words.add("aa");
words.add("ab");
words.add("ac");
words.add("ba");
Collections.sort(words);

String startsWith = "a";
int first = Collections.binarySearch(words, startsWith);
int last = Collections.binarySearch(words, startsWith.concat("\uFFFF"));
if (first < 0) first = ~first;
if (last < 0) last = ~last - 1;
for (int i = first; i <= last; i++) {
    System.out.println(words.get(i));
}