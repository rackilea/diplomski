Set<Node> items = scatterChart.lookupAll("Label.chart-legend-item");
             int it=0;
             for (Node item : items) {
                  Label label = (Label) item;
                  label.setGraphic(seriesNodes.get(it));
                  it++;
             }