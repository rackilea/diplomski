public class SearchTerm {
    private final String term;
    private final boolean caseSensitive;

    public SearchTerm(final String term, final boolean caseSensitive) {
        this.term = term;
        this.caseSensitive = caseSensitive;
    }

    public String getTerm() {
        return term;
    }

    public boolean isCaseSensitive() {
        return caseSensitive;
    }
}