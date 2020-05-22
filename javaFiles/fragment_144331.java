// your patterns
String[] array = new String[] { 
    "(car)|(truck)|(bus)|(van)", // 4) // transportation
    "(w)|(x)|(y)|(z)", // 1) options
    "1|2|3|4", // 2) numbers
    "(red)|(blue)|(green)|(pink)|(yellow)" // 3) color
};
// your input
String s = "1 blue w truck";

// the definition of the relevant information you want to keep on matches
class MatchInfo implements Comparable<MatchInfo>{
    int index;
    Integer start;
    String match;
    MatchInfo(int index, int start, String match) {
        this.index = index;
        this.start = start;
        this.match = match;
    }
    @Override
    // comparing start index of the match within original string
    public int compareTo(MatchInfo o) {
        return start.compareTo(o.start);
    };
}
// orders unique elements by natural ordering, as defined by Comparable 
// implementation
Set<MatchInfo> groups = new TreeSet<>();

// your original iteration
for (int i = 0; i < array.length; i++) {
    Pattern word = Pattern.compile(array[i]);
    Matcher match = word.matcher(s);
    while (match.find()) {
        // adding new "MatchInfo" to the set
        groups.add(new MatchInfo(i, match.start(), match.group()));
    }
}

// iterating and printing the info
for (MatchInfo m: groups) {
    System.out.printf("Using regex %d: %s%n", m.index, m.match);
}