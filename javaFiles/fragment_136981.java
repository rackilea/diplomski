public class PrintWorker implements Worker {
    public void work() {
        System.out.println("Print something");
    }
}

public class AnotherPrintWorker implements Worker {
    public void work() {
        System.out.println("A different action here");
    }
}