public class ConcurrentTest {

    public static void main(String[] args) {
        List<String> things = new ArrayList<>();

        Runnable modifyThread = () -> {
            while(true) {
                for(int k = 0; k < 1000; k++) {
                    things.add(String.valueOf(k));
                }

                while(!things.isEmpty()) {
                    things.remove(0);
                }
            }
        };

        Runnable readThread = () -> {
            while(true) {
                for(String thing : Collections.synchronizedList(things)) {
                    System.out.println(thing);
                }
            }
        };

        new Thread(modifyThread).start();
        new Thread(readThread).start();
    }
}