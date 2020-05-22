class ThreadTask implements Runnable {
    private int rowId;
    private int[][] matrix;

    public ThreadTask(int[][] matrix, int rowId) {
        this.matrix = matrix; // only a reference is passed here so no worries
        this.rowId = rowId;
    }

    public void run() {
       // search on my row
    }
}