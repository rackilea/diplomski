Region chartContent = (Region) lineChart.lookup(".chart-content");
for( Node node: chartContent.getChildrenUnmodifiable()) {
    if( node instanceof Group) {
        Group plotArea= (Group) node;
        plotArea.setClip(null);
    }
}