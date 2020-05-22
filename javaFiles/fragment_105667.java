public interface DataWriter {
    public default void writeData(OutputStream stream) {
        //no-behavior
    }

    public default void writeData(Writer writer) {
        //no-behavior
    }
}