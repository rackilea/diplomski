class IteratorTesting implements Iterator<List<String>> {

    private final Iterator<List<String>> iterator;
    private final Pattern pattern;

    private boolean hasNext = false;
    private List<String> next = null;
    private String startNext = null;

    public IteratorTesting(Iterator<List<String>> iterator, String regex) {
        this.iterator = iterator;
        this.pattern = Pattern.compile(regex);

        hasNext = checkNext();
    }

    @Override
    public boolean hasNext() {
        return hasNext;
    }

    private boolean checkNext() {
        String matchWord = null;
        List<String> result = new ArrayList<>();
        if(startNext != null)
            result.add(startNext);

        while(iterator.hasNext()) {
            List<String> line = iterator.next();
            for(String word : line) {
                Matcher matcher = pattern.matcher(word);
                if(matcher.find()) {
                    if(null != matchWord || startNext != null) {
                        next = result;
                        startNext = word;
                        return true;
                    } else {
                        matchWord = word;
                    }
                }
                if(null != matchWord || startNext != null) {
                    result.add(word);
                }
            }
        }
        next = result;
        startNext = null;
        return !next.isEmpty();
    }

    @Override
    public List<String> next() {
        List<String> current = next;
        hasNext = checkNext();
        return current;
    }
}