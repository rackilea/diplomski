public void checkN(Cell [][] arr, Cell [][] futureGen, int columns, int rows)
{
    ArrayList<Thread> threads = new ArrayList<>();
    for (int row = 0; row < rows; row++) {
        for (int column = 0; column < columns; column++) {
            Integer thread_local_row = row;
            Integer thread_local_column = column;
            Thread t = new Thread(() -> {
                countNeighbors(arr, thread_local_row, thread_local_column, rows, columns);
                evaluateNeighbors(arr[thread_local_row][thread_local_column], futureGen[thread_local_row][thread_local_column]);
            });
            t.start();
            threads.add(t);
        }
    }
    for(Thread t : threads)
        t.join();
}