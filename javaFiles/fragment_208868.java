final String POISON_PILL = " POISON";

class Producer implements Runnable {
    public void run() {
        while (true) {
            String s = read();
            if (s.equals("X"))
                break;
            try {
                queue.put(s);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            queue.put(POISON_PILL);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

class Consumer implements Runnable {
    public void run() {
        String s = null;
        try {
            while ((s = queue.take()) != POISON_PILL) {
                process(s);
            }
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}