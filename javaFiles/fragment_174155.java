public class MemorySpace {
  private final Map<String, Memory> memorySpace;

  public MemorySpace() {
    this.memorySpace = new HashMap<>();
  }

  public void addWord(String word) {
     Memory m = this.memorySpace.get(word);

     if (m == null) {
        this.memorySpace.put(word, new Memory(true, word))
     }
  }

  public void addSentence(String sentence) {
     Memory m = this.memorySpace.get(sentence);

     if (m == null) {
        this.memorySpace.put(sentence, new Memory(false, sentence))
     }
     else {
        m.increaseSeenCount();
     }
  }

  public boolean isMemoryPermanent(String workOrSentence) {
    Memory m = this.memorySpace.get(wordOrSentence)

    if (m != null) {
      return m.isMemoryPermanent();
    }

    return false;
  }

  public boolean isMemoryActive(String workOrSentence) {
    Memory m = this.memorySpace.get(wordOrSentence)

    if (m != null) {
      return m.isMemoryActive();
    }

    return false;
  }

  private class Memory {
    private final boolean isWordMemory;
    private final String wordOrSentence;

    private       int seenCount;
    private       long lastSeenAtMilliseconds;

    Memory(boolean isWordMemory, String newWordOrSentence) {
      this.isWordMemory = isWordMemory;
      this.wordOrSentence = newWordOrSentence;
      this.seenCount = 1;
      this.lastSeenAtMilliseconds = System.currentTimeMillis();
    }

    boolean isWordMemory() {
      return this.isWordMemory;
    }

    void increaseSeenCount() {
      if (!this.isWordMemory) {
        if (this.seenCount < 5) {  // Stop overflow
          this.seenCount++;
        }

        this.lastSeenAtMilliseconds = System.milliseconds();
      }
    }

    void isMemoryPermanent() {
      return this.isWordMemory || this.seenCount >= 5;
    }

    void isMemoryActive() {
      return this.isWordMemory || this.isMemoryPermanent() || (System.currentTimeMillis() - this.lastSeenAtMilliseconds) < (18 * 1000);
    }
  }
}