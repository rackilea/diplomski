public void println(boolean x) {
    synchronized (this) {
        print(x);
        newLine();
    }
}