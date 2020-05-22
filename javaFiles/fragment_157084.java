public class WordListUpateEvent {

    private final int changedIndex;

    public WordListUpateEvent(int changedIndex) {       
        this.changedIndex = changedIndex;
    }

    public int getChangedIndex() {
        return changedIndex;
    }
}