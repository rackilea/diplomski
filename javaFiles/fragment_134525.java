public class Prime extends Thread {

    static ArrayBlockingQueue<Integer> primeList;
    int start, end;

    public Prime(int start, int end) {
        this.start = start;
        this.end = end;
    }

    ...

        for (int n = start; n <= end n++) {