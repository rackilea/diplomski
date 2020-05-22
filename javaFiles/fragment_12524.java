private final class ATCpool implements Runnable {

    private final int x;
    private final String link;

    ATCpool(int x, String link){
        this.x = x;
        this.link = link;
    }

    @Override
    public void run() {
        // Will be called asynchronously by a thread of the thread pool
        Generator.atcThread[x].get(link);
    }
}