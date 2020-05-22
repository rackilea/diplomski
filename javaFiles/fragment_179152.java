you can try it out with this POJOs.

class TransactionData {
    private String key;
    private List<Data> values;
    public TransactionData(String key, List<Data> values) {
        this.key = key;
        this.values = values;
    }
}
class Data {
    private String x;
    private Integer y;
    public Data(String x, Integer y) {
        this.x = x;
        this.y = y;
    }
}