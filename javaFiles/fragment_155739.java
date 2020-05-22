public class Pattern {
     string pattern;
     PatternType type;
     Relation r;

     @Override
     public int hashCode() {
        return 371 * pattern.hashCode();
     }

     @Override 
     public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || this.getClass() != other.getClass()) return false;

        Pattern pattern = (Pattern) other;
        return this.pattern.equals(pattern.pattern);
     }
}