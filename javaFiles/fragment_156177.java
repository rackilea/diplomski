class IndexKey{
    public final int lineIndex;
    public final int wordIndex;
    public IndexKey(int lineIndex, int keyIndex){
        this.lineIndex = lineIndex;
        this.wordIndex = wordIndex;
    }

    @Override
    public int hashCode() {
       int hash = 7;
       hash = 97 * hash + lineIndex;
       hash = 97 * hash + wordIndex;
       return hash
    }

    @Override
    public boolean equals(Object obj) {
       if (obj == null) {
          return false;
       }
       if (getClass() != obj.getClass()) {
          return false;
       }
       final IndexKey other = (IndexKey) obj;
       if (this.lineIndex != other.lineIndex) {
          return false;
       }
       if (this.wordIndex != other.wordIndex) {
          return false;
       }
       return true;
    }
}

Map<IndexKey, Object> map = new HashMap<>();

object.set(new IndexKey(lineIndex, keyIndex), value);
value=object.get(new IndexKey(lineIndex, wordIndex));