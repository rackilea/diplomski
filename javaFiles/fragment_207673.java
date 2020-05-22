// some untested code
class A {
    final int x_DEFAULT = 0;
    int x = 0;

    void reloadVars() {
        x = x_DEFAULT;
    }

    A() {
        new Timer().scheduleAtFixedRate(new TimerTask() {
            public void run() {
                reloadVars();
            }
        }, 60000, 60000);
    }
}