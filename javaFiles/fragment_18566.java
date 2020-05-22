public class Test {
    static List<Thread> threadList = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        Map<Integer,String> map = new HashMap<>();
        for (int i =0;i < 1000;i++) {
            startUpdateThread(i, map);
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println("Key :"+entry.getKey()+" Value:"+entry.getValue());
        }

        for (Thread thread : threadList) {
            thread.interrupt();
        }
    }

    private  static void startUpdateThread(int i, final Map<Integer, String> concurrentMap) {
        Thread thread = new Thread(new Runnable() {
            public void run() {
                Random random = new Random();
                while (true) {
                    int randomInt = random.nextInt(10000);
                    concurrentMap.put(randomInt, UUID.randomUUID().toString());
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        return;
                    }
                }
            } });

        threadList.add(thread);

        thread.setName("Update Thread " + i);
        thread.start();
    }
}