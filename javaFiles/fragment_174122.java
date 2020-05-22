public void checkN(Cell [][] arr, Cell [][] futureGen, int columns, int rows)
{
    ArrayList<Thread> threads = new ArrayList<>();
    final int NUM_OF_THREADS = 8; //Or can be passed as an argument
    for(int tid = 0; tid < NUM_OF_THREADS; tid++) {
        Integer thread_local_row_start = tid * rows / NUM_OF_THREADS;
        Integer thread_local_row_end = (tid + 1) * rows / NUM_OF_THREADS;
        Thread t = new Thread(() -> {
            for (int row = thread_local_row_start; row < thread_local_row_end; row++) {
                for (int column = 0; column < columns; column++) {
                    countNeighbors(arr, row, column, rows, columns);
                    evaluateNeighbors(arr[row][column], futureGen[row][column]);
                }
            }
        });
        t.start();
        threads.add(t);
    }
    for(Thread t : threads)
        t.join();
}