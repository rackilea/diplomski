Main plugin;
ToggleAFK afk;
public AfkCommand (Main instance) {
    plugin = instance;
    afk = new ToggleAFK(plugin);
}