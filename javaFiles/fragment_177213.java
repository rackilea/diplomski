public class ThreadTask implements Runnable {
    private List datalines = new ArrayList();

    public ThreadTask(List datalines) {
        this.datalines.add(datalines);
    }

    public void run() {
       Collections.sort(datalines,mycomparator);
       synchronized(vector) {
           vector.add(datalines); 
       }
    }
}