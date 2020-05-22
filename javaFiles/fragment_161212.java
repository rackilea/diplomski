public class OrintMapRun implements Callable<List<Integer>> {
    final int partOne, partTwo;
    final List<Integer> resultList = new ArrayList<>();
    public OrintMapRun(int partOne, int partTwo) {
        this.partOne = partOne;
        this.partTwo = partTwo;
    }

    @Override
    public List<Integer> call() throws Exception {
        resultList.add(partOne);
        resultList.add(partTwo);
        Thread.sleep(5000); //simulate some computation
        return resultList;
    }
}