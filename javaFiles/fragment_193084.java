abstract class MainMenu {
    public abstract void notifyMain();
}
//inside Main class
JMenuBar menu = new MainMenu() {
    public abstract void notifyMain(Object notification) {
        Main.this.notifyMain(notification);
    }
};