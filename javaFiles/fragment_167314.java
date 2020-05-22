public class PatternWrapper{
    private final Pattern pattern;

    public PatternWrapper(Pattern p) {
        this.pattern = p;
    }

    /**
     * @return the pattern
     */
    public Pattern getPattern() {
        return pattern;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((pattern == null) ? 0 : pattern.hashCode());
        return result;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (!(obj instanceof PatternWrapper))
            return false;
        PatternWrapper other = (PatternWrapper) obj;
        if (pattern == null) {
            if (other.pattern != null)
                return false;
        } else if (!pattern.toString().equals(other.pattern.toString()))
            return false;
        return true;
    }
}