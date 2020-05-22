public class MeshTask extends RecursiveTask<long[]> {
    public static long[] refineGrid(long[] cellsToProcess) {
        return new MeshTask(cellsToProcess, 0, cellsToProcess.length).compute();
    }
    private final long[] source;
    private final int from, to;

    private MeshTask(long[] src, int from, int to) {
        source = src;
        this.from = from;
        this.to = to;
    }
    @Override
    protected long[] compute() {
        return compute(source, from, to);
    }
    private static long[] compute(long[] source, int from, int to) {
        long[] result = new long[to - from];
        ArrayDeque<MeshTask> next = new ArrayDeque<>();
        while(getSurplusQueuedTaskCount()<3) {
            int mid = (from+to)>>>1;
            if(mid == from) break;
            MeshTask task = new MeshTask(source, mid, to);
            next.push(task);
            task.fork();
            to = mid;
        }
        int pos = 0;
        for(; from < to; ) {
            long value = source[from++];
            if(checkCell(value)) result[pos++]=value;
            else {
                long[] array = generate(value);
                array = compute(array, 0, array.length);
                result = Arrays.copyOf(result, result.length+array.length-1);
                System.arraycopy(array, 0, result, pos, array.length);
                pos += array.length;
            }
            while(from == to && !next.isEmpty()) {
                MeshTask task = next.pop();
                if(task.tryUnfork()) {
                    to = task.to;
                }
                else {
                    long[] array = task.join();
                    int newLen = pos+to-from+array.length;
                    if(newLen != result.length)
                        result = Arrays.copyOf(result, newLen);
                    System.arraycopy(array, 0, result, pos, array.length);
                    pos += array.length;
                }
            }
        }
        return result;
    }
    static boolean checkCell(long cellId) {
        return cellId > 1000;
    }
    static long[] generate(long cellId) {
        long[] sub = new long[8];
        for(int i = 0; i < sub.length; i++) sub[i] = cellId*10+i;
        return sub;
    }
}