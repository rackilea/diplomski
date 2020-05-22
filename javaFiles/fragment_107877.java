public HashMap<String, Integer> countWords(String str) {
    HashMap<String, Integer> counts = new HashMap<String, Integer>();
    for(String s : str.split("\\s+")) {
        if(!s.isEmpty()) {
            if(counts.containsKey(s)) {
                counts.put(s, counts.get(s) + 1);
            } else {
                counts.put(s, 1);
            }
        }
    }
    return counts;
}

// ...

String s1 = "some filename contains few words.txt";
String s2 = "some filename not contains few words.txt";
HashMap<String, Integer> s1Counts = countWords(s1);
HashMap<String, Integer> s2Counts = countWords(s2);
// assume s1 is "master" string, count the total number of words
int s1Total = 0, s2Total = 0;
for(Integer i : s1Counts.values()) {
    s1Total += i;
}
// iterate over words in s1, find the number of matching words in s2
for(Map.Entry<String, Integer> entry : s1Counts.entrySet()) {
    if(s2Counts.containsKey(entry.getKey())) {
        if(s2Counts.get(entry.getKey()) >= entry.getValue()) {
            s2Total += entry.getValue();
        } else {
            s2Total += s2Counts.get(entry.getKey());
        }
    }
}
// result
System.out.println(s2Total + " out of " + s1Total + " words match.");