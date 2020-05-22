import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class MultiThreadsMatrixMultipy {

    public static void main(final String[] args) {

    }

    public int[][] multipy(final int[][] matrix1, final int[][] matrix2) {
        if(!utils.CheckDimension(matrix1,matrix2)){
            return null;
        }
        final int row1 = matrix1.length;
        final int col2 = matrix2[0].length;
        final int[][] ans = new int[row1][col2];
        // final Executor executor = Executors.newCachedThreadPool(new CustomThreadFactory("Multiplier"));
        final Executor executor = Executors.newFixedThreadPool(20, new CustomThreadFactory("Multiplier"));

        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < col2; j++) {
                executor.execute(new SingleRowMultipy(i, j, matrix1, matrix2, ans));
            }
        }
        return ans;
    }
}

class CustomThreadFactory implements ThreadFactory {
    private int counter;
    private final String name;
    private final List<String> stats;

    public CustomThreadFactory(final String name) {
        counter = 1;
        this.name = name;
        stats = new ArrayList<>();
    }

    @Override
    public Thread newThread(final Runnable runnable) {
        final Thread t = new Thread(runnable, name + "-Thread_" + counter);
        counter++;
        stats.add(String.format("Created thread %d with name %s on %s \n", t.getId(), t.getName(), new Date()));
        return t;
    }

    public String getStats() {
        final StringBuffer buffer = new StringBuffer();
        final Iterator<String> it = stats.iterator();
        while (it.hasNext()) {
            buffer.append(it.next());
        }
        return buffer.toString();
    }
}

class SingleRowMultipy implements Runnable {
    private final int row;
    private final int col;
    private final int[][] A;
    private final int[][] B;
    private final int[][] ans;

    public SingleRowMultipy(final int row, final int col, final int[][] A, final int[][] B, final int[][] C) {
        this.row = row;
        this.col = col;
        this.A = A;
        this.B = B;
        this.ans = C;
    }

    @Override
    public void run() {
        int sum = 0;
        for (int i = 0; i < A[row].length; i++) {
            sum += (A[row][i] * B[i][col]);
        }
        ans[row][col] = sum;
    }
}