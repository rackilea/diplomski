public class South {
    private Queue<Car> q = new LinkedList<Car>();

    public void CreateQueue() { ... }

    public void poll() {
        System.out.print("The car with registration number: ");
        System.out.print(q.poll().getRegNum());
        System.out.println(" have passed the bridge from the South side.");
    }
}

public class North {
    private Queue<Car> q = new LinkedList<Car>();

    public void CreateQueue() { ... }

    public void poll() {
        System.out.print("The car with registration number: ");
        System.out.print(q.poll().getRegNum());
        System.out.println(" have passed the bridge from the North side.");
    }
}

// This is the "master" class
public class Main {
    public static void main(String[] args) {
        South south = new South();
        North north = new North();

        south.CreateQueue();
        north.CreateQueue();

        boolean done = false;
        while (!done) {
            try {
                Thread.sleep(2000);
            } (catch InterruptedException) { /* TODO */ }

            north.poll();

            try {
                Thread.sleep(2000);
            } (catch InterruptedException) { /* TODO */ }

            south.poll();
        }
    }
}