public class Scratch {
    private List<Integer> scores = Collections.synchronizedList(new ArrayList<Integer>());

    public static void main(String[] args) throws Exception {
        final Scratch s = new Scratch();
        s.scores.add(1);
        s.scores.add(2);
        s.scores.add(3);

        // keep adding things to the list forever
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    int i=100;
                    while (true) {
                        Thread.sleep(100);
                        s.scores.add(i++);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        System.out.println("This will run fine");
        s.safeLoop();

        System.out.println("This will cause a ConcurrentModificationException");
        s.unsafeLoop();
    }

    public void safeLoop() throws InterruptedException {
        synchronized (scores) {
            for (int i : scores) {
                System.out.println("i="+i);
                Thread.sleep(100);
            }
        }
    }

    public void unsafeLoop() throws InterruptedException {
        for (int i : scores) {
            System.out.println("i="+i);
            Thread.sleep(100);
        }
    }
}