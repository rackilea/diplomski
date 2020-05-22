public class SubsetCallable implements Callable<List<Integer>> {
    X x;
    public SubsetCallable(X x) {
        this.x = x;
    }
    public List<Integer> call() {
        return Util.getSubsetOfX(x);
    }
}