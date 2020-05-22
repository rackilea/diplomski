protected static Properties props; // << NULL

public void onModuleLoad() {
    loadProps(); // props is still NULL
    buildUI();
}

void loadProps() {
    // props is still NULL
    props.set("scarsa manutenzione manto stradale", "images/red.png"); // BANG!
[...]