Set<Character> set = new HashSet<Character>();
for (int i = 0; i < s.length(); i++) {
    Character c = s.charAt(i);
    // add returns true if the element was added (i.e. it's new) and false
    // otherwise (we've seen this character before)
    if (!set.add(c)) {
        return false;
    }
}
return true;