public String removeDuplicateLetters(String s) {
    StringBuilder result = new StringBuilder();
    int[] subsets = new int[s.length()];

    int subset = 0;
    for (int i = s.length() - 1; i >= 0; i--) {
        char ch = s.charAt(i);
        subset = addToSet(subset, ch);
        subsets[i] = subset;
    }

    int curPos = 0;
    while (subset != 0) {
        for (char ch = 'a'; ch <= 'z'; ++ch) {
            if (inSet(subset, ch)) {
                int chPos = s.indexOf(ch, curPos);
                if (includes(subsets[chPos], subset)) {
                    result.append(ch);
                    subset = removeFromSet(subset, ch);
                    curPos = chPos + 1;
                    break;
                }
            }
        }
    }

    return result.toString(); 
}   

private boolean inSet(int set, char ch) {
    return (set & (1 << (ch - 'a'))) != 0;    
}

private boolean includes(int set, int subset) {
    return (set | subset) == set;
}

private int addToSet(int set, char ch) {
    return set | (1 << (ch - 'a'));
}

private int removeFromSet(int set, char ch) {
    return set & ~(1 << (ch - 'a')); 
}