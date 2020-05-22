public class Cube {

    private HashMap<IntTuple, IntPair> cubeMap = new HashMap<IntTuple, IntPair>();
    private zeroPair = new IntPair(0, 0);

    public addPair(IntTuple coords, IntPair pair) {
        cubeMap.put(coords, pair);
    }

    public IntPair getPair(IntTuple coords) {
        if (cubeMap.containsKey(coords))
            return cubeMap.get(coords);
        else
            return zeroPair;
    }
}