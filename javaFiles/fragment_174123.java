public void checkN(final Cell [][] arr, final Cell [][] futureGen, final int columns, final int rows)
{
    ArrayList<Thread> threads = new ArrayList<>();
    for (int row = 0; row < rows; row++) {
        for (int column = 0; column < columns; column++) {
            final Integer thread_local_row = row;
            final Integer thread_local_column = column;
            Thread t = new Thread(new Runnable() {
                public void run() {
                    countNeighbors(arr, thread_local_row, thread_local_column, rows, columns);
                    evaluateNeighbors(arr[thread_local_row][thread_local_column], futureGen[thread_local_row][thread_local_column]);
                }
            });
            t.start();
            threads.add(t);
        }
    }
    for(Thread t : threads)
        t.join();
}