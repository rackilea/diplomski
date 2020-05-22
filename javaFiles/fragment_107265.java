...
            series1.setShowLeaderLines(true); // this sets default data lables
            // customizing data labels
            int seriesNr = 0;
            //chart.getCTChart().getPlotArea().getLineChartArray(0).getSerArray(seriesNr).getDLbls()
            // .addNewSpPr().addNewSolidFill().addNewSrgbClr().setVal(new byte[]{(byte)255,(byte)255,0});
            chart.getCTChart().getPlotArea().getLineChartArray(0).getSerArray(seriesNr).getDLbls()
             .addNewDLblPos().setVal(org.openxmlformats.schemas.drawingml.x2006.chart.STDLblPos.CTR);
            chart.getCTChart().getPlotArea().getLineChartArray(0).getSerArray(seriesNr).getDLbls().addNewShowVal().setVal(true);
            chart.getCTChart().getPlotArea().getLineChartArray(0).getSerArray(seriesNr).getDLbls().addNewShowLegendKey().setVal(false);
            chart.getCTChart().getPlotArea().getLineChartArray(0).getSerArray(seriesNr).getDLbls().addNewShowCatName().setVal(false);
            chart.getCTChart().getPlotArea().getLineChartArray(0).getSerArray(seriesNr).getDLbls().addNewShowSerName().setVal(false);
...