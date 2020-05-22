abstract class UI {
    public abstract void start();
}

abstract class SplashableUI {
    private SplashScreen splash;

    public SpashableUI(SplashScreen splash) {
        this.splash = splash;
    }

    public final void start() {
        splash.start();
        init();
        splash.end();
    }

    public abstract void init();
}