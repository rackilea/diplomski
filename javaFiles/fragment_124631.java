public static Iterable<String> combinations(String text, String... replacements) {
    Map<Character, String> repl = new HashMap<>();
    for (String r : replacements)
        if (repl.putIfAbsent(r.charAt(0), r) != null)
            throw new IllegalArgumentException("Duplicate replacement: [" + repl.get(r.charAt(0)) + "] vs [" + r + "]");
    String[] textChars = new String[text.length()];
    long count = 1;
    for (int i = 0; i < textChars.length; i++) {
        textChars[i] = repl.getOrDefault(text.charAt(i), text.substring(i, i+1));
        count = Math.multiplyExact(count, textChars[i].length());
    }
    long comboCount = count;
    return () -> new Iterator<>() {
        private long combo = 0;
        @Override
        public boolean hasNext() {
            return (this.combo < comboCount);
        }
        @Override
        public String next() {
            if (this.combo >= comboCount)
                throw new NoSuchElementException();
            long c = this.combo++;
            char[] buf = new char[textChars.length];
            for (int i = buf.length - 1; i >= 0; i--) {
                buf[i] = textChars[i].charAt((int) (c % textChars[i].length()));
                c /= textChars[i].length();
            }
            return new String(buf);
        }
    };
}