public boolean isValidChar(CharSequence seq) {
    int len = seq.length();
    for(int i=0;i<len;i++) {
        char c = seq.charAt(i);
        // Test for all positive cases
        if('0'<=c && c<='9') continue;
        if('a'<=c && c<='z') continue;
        if('A'<=c && c<='Z') continue;
        if(c==' ') continue;
        if(c=='-') continue;
        // ... insert more positive character tests here
        // If we get here, we had an invalid char, fail right away
        return false;
    }
    // All seen chars were valid, succeed
    return true;
}