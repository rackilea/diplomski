public class MyRecursiveAction extends RecursiveAction {

    public static void main(String[] args) {
        MyRecursiveAction mra1 = new MyRecursiveAction(100);
        ForkJoinPool fjp1 = new ForkJoinPool();
        fjp1.invoke(mra1);
    }

    private long workLoad = 0;

    public MyRecursiveAction(long workLoad) {
        this.workLoad = workLoad;
    }

    @Override
    protected void compute() {

        //if work is above threshold, break tasks up into smaller tasks
        if(this.workLoad > 16) {
            System.out.println("Splitting workLoad : " + this.workLoad);

            invokeAll(new MyRecursiveAction(this.workLoad / 2), new MyRecursiveAction(this.workLoad / 2));

        } else {
            System.out.println("Doing workLoad myself: " + this.workLoad);
        }
    }

}