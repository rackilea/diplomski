public void println(String x) {
    synchronized (this) {
        print(x);  // break point here
        newLine();
    }
}