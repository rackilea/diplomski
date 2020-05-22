class Producer implements Runnable {
    private TwitterObj obj;

    public Producer(TwitterObj obj) {
        this.obj = obj;
    }

    @Override
    public void run() {
        try {
            queue.put(obj);
            System.out.println("Put OBJ into queue: " + obj.getMsg());
            ++i;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    };
}