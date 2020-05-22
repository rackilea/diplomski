class ReadThread implements Runnable {

    private final String filename;
    private final ConcurrentLinkedQueue<Integer> queue;

    public ReadThread(ConcurrentLinkedQueue<Integer> queue, String filename) {
        this.queue = queue;
        this.filename = filename;
    }

    public void run() {
        try {
            FileInputStream fs = new FileInputStream(filename);
            Scanner scanner = new Scanner(fs);
            while (scanner.hasNextInt()) {
                int number = scanner.nextInt();
                System.out.println("ReadThread read " + number);
                queue.add(number);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}