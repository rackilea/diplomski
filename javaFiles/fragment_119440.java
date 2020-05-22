// put the characters into an array
Character[] chars = new Character[str.length()];
for (int i = 0; i < chars.length; i++)
    chars[i] = str.charAt(i);

// sort the array
Arrays.sort(chars, new Comparator<Character>() {
    public int compare(Character c1, Character c2) {
        int cmp = Character.compare(
            Character.toLowerCase(c1.charValue()),
            Character.toLowerCase(c2.charValue())
        );
        if (cmp != 0) return cmp;
        return Character.compare(c1.charValue(), c2.charValue());
    }
});

// rebuild the string
StringBuilder sb = new StringBuilder(chars.length);
for (char c : chars) sb.append(c);
str = sb.toString();