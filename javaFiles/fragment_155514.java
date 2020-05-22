public class DataProbability implements Comparable<DataProbability> {
    private int data;
    private double probability;

    public int getData() {
        return data;
    }

    public double getProbability() {
        return probability;
    }

    public int compareTo(DataProbability pProb) {
        return Double.compare(getProbability(), pProb.getProbability());
    }
}

// Later, with your list
List<DataProbability> lDataList = new ArrayList<DataProbability>();
// Add some elements
Collections.sort(lDataList);