private class Row {
    public Integer i;
    public String s;
    public LatLng ll;

    public Row(Integer i, String s, LatLng ll) {
        this.i = i; 
        this.s = s;
        this.ll = ll;
    }
}

List<Row> rows = new ArrayList<Row>();