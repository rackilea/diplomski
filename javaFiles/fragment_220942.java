public CharMatcher newRegexLikeCharMatcher(String regex) {
    final Pattern pattern = Pattern.compile(regex);
    return new CharMatcher() {
        @Override
        public boolean matches(char c) {
            return pattern.matcher(Character.toString(c)).find();
        }
    }.precomputed();
}