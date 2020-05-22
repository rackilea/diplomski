public class Main {

    public static class Singleton {

        private static Singleton instance = new Singleton();

        public static Singleton getInstance() {
            return instance;
        }

        private char[] value = new char[50];

        private Singleton() {
        }

        public void printValue() {
            for (int i = 0; i < value.length; i++) {
                System.out.print(value[i]);
            }
            System.out.println();
        }

        public void setValue(String newValue) {
            for (int i = 0; i < newValue.length() && i < value.length; i++) {
                value[i] = newValue.charAt(i);
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    // Ignore
                }
            }
        }

    }

    public static void main(String[] args) {
        final int MAX = 100000;

        Thread thread1 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < MAX; i++) {
                    Singleton.getInstance().setValue("00000000000000000000000000000000000000000000000000");
                    yield();
                }
            }
        };

        Thread thread2 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < MAX; i++) {
                    Singleton.getInstance().setValue("11111111111111111111111111111111111111111111111111");
                    yield();
                }
            }
        };

        Thread thread3 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < MAX; i++) {
                    System.out.printf("%5d:   ", i);
                    Singleton.getInstance().printValue();
                    yield();
                }
            }
        };

        thread1.start();
        thread2.start();
        thread3.start();
    }

}