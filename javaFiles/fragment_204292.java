...
public class YourPlugin extends JavaPlugin {
    ...
    private boolean eventMode; //false per default
    ...

    public boolean toggleEventMode() {
        eventMode = !eventMode; //negation so if it is true it will be turned into false if it is false it will be turned to true
        return eventMode;
    }
    public boolean isEventMode() {
        return eventMode;
    }
}