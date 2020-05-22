public class ChartModel extends Observable {

    private final Map<String, Double> data = new LinkedHashMap<>();

    public Map<String, Double> getData() {
        return data;
    }

    public void setChartData(String[] d, double[] dd) {
        if (d.length != dd.length) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < d.length; i++) {
            data.put(d[i], dd[i]);
        }
        setChanged();
        notifyObservers();
    }

    public void updateCharData(String dataName, double newData) {
        data.put(dataName, newData);
        setChanged();
        notifyObservers();
    }
}