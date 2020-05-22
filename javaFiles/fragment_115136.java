public abstract class MyPluginBase extends JavaPlugin {
    public abstract String getCompath();
    ....
}

public class MyPlugin extends MyPluginBase {
    @Override
    public String getCompath() {
        return "CommandFileName";
    }

    @Override
    public void onEnable() {
        this.getServer().getPluginManager().registerEvents(
               new MyListener(this), this);
    }
}

public MyListener(MyPluginBase instance) {
    path = instance.getCompath();
    ...
}