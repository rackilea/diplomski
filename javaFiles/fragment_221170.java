class dataModel implements Serializable {
    private String id, name;
    private Integer count;
    @ServerTimestamp
    private Date time;

    dataModel() {}

    dataModel(String id, String name, Integer count) {
        this.id = id;
        this.name = name;
        this.count = count;
    }
}