public class MonitorsList {

    @JsonProperty("monitors")
    private List<Monitors> monitors;

    public void setMonitors(List<Monitors> monitors) {
        this.monitors = monitors;
    }

    public List<Monitors> getMonitors() {
        return this.monitors;
    }

    @JsonProperty("is_alive")
    private boolean is_alive;

    public void setIsAlive(boolean is_alive) {
        this.is_alive= is_alive;
    }

    public boolean getIsAlive() {
        return this.is_alive;
    }
}