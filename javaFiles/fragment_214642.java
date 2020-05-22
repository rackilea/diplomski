public class Task4 {
    static StringBuilder stringBuilder = new StringBuilder("");
    static final StringBuilder SEPARATOR = new StringBuilder("/");

    static long N = 1000000;

    public static void main(String[] args) {
        MyStringBufferThreadReader myStringBufferThreadReader = new MyStringBufferThreadReader(stringBuilder);
        MyStringBufferThreadWriter myStringBufferThreadWriter = new MyStringBufferThreadWriter(stringBuilder);
        new Thread(myStringBufferThreadReader).start();
        new Thread(myStringBufferThreadWriter).start();
        new Thread(myStringBufferThreadReader).start();
        new Thread(myStringBufferThreadWriter).start();
    }
}

class MyStringBufferThreadReader implements Runnable {
    StringBuilder stringBuilder;

    public MyStringBufferThreadReader(StringBuilder stringBuffer) {
        this.stringBuilder = stringBuffer;
    }

    @Override
    public void run() {
        for (int i = 0; i < Task4.N; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("READ:  " + stringBuilder);
        }
    }
}

class MyStringBufferThreadWriter implements Runnable {
    static StringBuilder stringBuilder;

    public MyStringBufferThreadWriter(StringBuilder stringBuffer) {
        this.stringBuilder = stringBuffer;
    }

    @Override
    public void run() {
        for (int i = 0; i < Task4.N; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("WROTE: " + stringBuilder.append(i).append(Task4.SEPARATOR));

        }
    }
}