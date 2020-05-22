public enum JobStatus implements Serializable{
    INCOMPLETE,
    INPROGRESS,
    ABORTED,
    COMPLETED;

    public String getStatus() {
        return this.name();
    }
}