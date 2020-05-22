public class Process implements Serializable {

    private String processName = null;

    public Process(String processName) {
        this.processName = processName;
    }

    @Override
    public String toString() {
        return processName;
    }
}