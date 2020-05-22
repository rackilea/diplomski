final int startIndex = i;
final int endIndex = i + 1;
new Thread(new Runnable() {
    public void run() {
        final int test = startIndex;
        final int test2 = endIndex;
    }
}).start();