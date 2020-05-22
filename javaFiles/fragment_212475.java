public class Visitors {
    @Important
    Counter counter = new Counter();

    public void increaseCounter() {
        counter.add(1);
    }

    public static void main(String[] args) {
        Visitors visitors = new Visitors();
        visitors.increaseCounter();
        visitors.counter.add(3);
        System.out.println("visitors.counter = " + visitors.counter);
        System.out.println("--------------------");

        Counter unimportantCounter = new Counter();
        unimportantCounter.add(11);
        unimportantCounter.add(22);
        System.out.println("unimportantCounter = " + unimportantCounter);
        System.out.println("--------------------");

        unimportantCounter = visitors.counter;
        unimportantCounter.add(5);
        System.out.println("visitors.counter = " + visitors.counter);
        System.out.println("unimportantCounter = " + unimportantCounter);
        System.out.println("--------------------");

        visitors.counter = new Counter();
        visitors.increaseCounter();
        visitors.counter.add(3);
        unimportantCounter.add(100);
        System.out.println("visitors.counter = " + visitors.counter);
        System.out.println("unimportantCounter = " + unimportantCounter);
        System.out.println("--------------------");

        Visitors otherVisitors = new Visitors();
        otherVisitors.increaseCounter();
        otherVisitors.counter.add(50);
        System.out.println("otherVisitors.counter = " + otherVisitors.counter);
        System.out.println("--------------------");

        otherVisitors.counter = visitors.counter;
        System.out.println("visitors.counter = " + visitors.counter);
        System.out.println("otherVisitors.counter = " + otherVisitors.counter);
        System.out.println("--------------------");

        otherVisitors.counter = new Counter();
        visitors.increaseCounter();
        otherVisitors.increaseCounter();
        System.out.println("visitors.counter = " + visitors.counter);
        System.out.println("otherVisitors.counter = " + otherVisitors.counter);
    }
}