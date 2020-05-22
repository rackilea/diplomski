class Wrapper{

    private IronRunId ironRunId;
    private long time;
    private Map<String, String> aspects;
    private String anotherString;

    public long getTime() {
        return time;
    }
    public void setTime(long time) {
        this.time = time;
    }
    public Map<String, String> getAspects() {
        return aspects;
    }
    public void setAspects(Map<String, String> aspects) {
        this.aspects = aspects;
    }
    public String getAnotherString() {
        return anotherString;
    }
    public void setAnotherString(String anotherString) {
        this.anotherString = anotherString;
    }
    public IronRunId getIronRunId() {
        return ironRunId;
    }
    public void setIronRunId(IronRunId ironRunId) {
        this.ironRunId = ironRunId;
    }
}