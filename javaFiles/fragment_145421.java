public void toArray() {
    String[] split = this.text.split("\n");
    this.data = new double[split.length][];
    for (int i=0 ; i<data.length ; i++) {
        String[] cols = split[i].split("\\s+");
        data[i] = new double[cols.length];
        for (int j=0 ; j<cols.length ; j++)
            data[i][j] = Double.parseDouble(cols[j]);
    }
}