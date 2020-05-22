public class customColorSeries  extends JRAbstractChartCustomizer  {

    @Override
    public void customize(JFreeChart chart, JRChart jasperChart) {

        BarRenderer renderer = (BarRenderer) chart.getCategoryPlot().getRenderer();
        CategoryDataset catDS = chart.getCategoryPlot().getDataset();
        com.fasterxml.jackson.databind.node.ArrayNode seriesColor = (ArrayNode) getParameterValue("seriesColor_P");
        HashMap<String, String> customMap = new HashMap<>();

        for (int z = 0; z < seriesColor.size(); z++) {  
            customMap.put(seriesColor.get(z).get("Object_Name").textValue(), seriesColor.get(z).get("Color").textValue());
        }

        for (int i = 0; i < catDS.getRowCount(); i++) {
            if(customMap.containsKey(catDS.getRowKey(i).toString())) {
                renderer.setSeriesPaint(i, Color.decode(customMap.get(catDS.getRowKey(i).toString())));
            }
        }
    }        
}