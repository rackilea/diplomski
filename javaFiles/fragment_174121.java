public void checkN(Cell [][] arr, Cell [][] futureGen, int columns, int rows)
{
    ArrayList<Thread> threads = new ArrayList<>();
    for (int row = 0; row < rows; row++) {
        Integer thread_local_row = row;
        Thread t = new Thread(() -> {
            for (int column = 0; column < columns; column++) {
                countNeighbors(arr, thread_local_row, column, rows, columns);
                evaluateNeighbors(arr[thread_local_row][column], futureGen[thread_local_row][column]);
            }
        });
        t.start();
        threads.add(t);
    }
    for(Thread t : threads)
        t.join();
}