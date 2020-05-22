@Override
public void run() {
    while (true) {
        String s = null;

        CalculateSomethingBig();

        synchronized (infiList) {
            ...
        }
    }
}