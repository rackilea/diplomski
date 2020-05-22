public void createAdditionalDataset() {
    seriesArrayList.add(createDataset("S" + this.datasetIndex));
    this.plot.setDataset(this.datasetIndex, seriesArrayList.get(datasetIndex));
    this.plot.setRenderer(this.datasetIndex, new StandardXYItemRenderer());
    this.datasetIndex++;
}