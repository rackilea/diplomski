public interface SequenceProvider {
    String getSequence();
}

public enum Telomeres implements SequenceProvider {
    /*
    ...
    */

    @Override
    public String getSequence() {
        return telomere;
    }
}