//Inside Other Class
JMenuBar menu = new MainMenu() {
    public abstract void notifyMain() {
        Other.this.notifyMain();
    }
};