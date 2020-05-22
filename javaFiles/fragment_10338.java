HashMap<Character, Boolean> tab = new HashMap<Character, Boolean>();
Character c;

for (int i = 0; i < s.length(); ++i) {
    c = new Character(s.charAt(i));
    if (tab.get(c) == null)
        tab.put(c, Boolean.TRUE);
    else
        return false;
}
return true;