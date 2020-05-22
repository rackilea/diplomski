public class ConcurrencySampleCode {

    private AtomicReference<DoubleMap> atomicMap = new AtomicReference(new DoubleMap());

    //Inner class used to hold the map and array pair
    public class DoubleMap {
        private Map<String, Integer> map = ...
        private double[] array = ...
    }

    public Double get(String id) {
        DoubleMap map = atomicMap.get();
            ...
    }

    public void update() {
        Map<String, Integer> tmpMap = updateMap(...);
        double[] tmpArray = updateArray(...);
        DoubleMap newMap = new DoubleMap(tmpMap, tmpArray);
        atomicMap.set(newMap);
    }

}