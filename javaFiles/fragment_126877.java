String seriesClass = null;
for(String styleClass : series.getNode().getStyleClass())
{
    if(styleClass.startsWith("series"))
    {
        for(javafx.scene.Node n : _chart.lookupAll("." + seriesClass))
        {
             n.setStyle("-fx-stroke-dash-array: 10 10");
        }
        break;
    }
}