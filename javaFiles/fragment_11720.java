private static int index(char c) {
    if (c < '0') throw new IllegalArgumentException("illegal char");
    if (c <= '9') return c - '0';
    if (c < 'a') throw new IllegalArgumentException("illegal char");
    if (c <= 'z') return c - 'a' + 10;
    throw new IllegalArgumentException("illegal char");
}

private static int solution(String s) {
    HashMap<BitSet, Integer> states = new HashMap<>();
    int longest = 0;
    BitSet state = new BitSet();
    states.put((BitSet) state.clone(), 0);
    for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        state.flip(index(c));
        Integer seenAt = states.get(state);
        if (seenAt != null) {
            int len = i - seenAt + 1;
            if (len > longest) longest = len;
        } else {
            states.put((BitSet) state.clone(), i + 1);
        }
    }
    return longest;
}