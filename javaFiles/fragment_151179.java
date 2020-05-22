// draw all the subplots
for (int i = 0; i < this.getSubplots().size(); i++) {
    CombinedRangeXYPlot plot = (CombinedRangeXYPlot) this.getSubplots().get(i);
    PlotRenderingInfo subplotInfo = null;
    if (info != null) {
        subplotInfo = new PlotRenderingInfo(info.getOwner());
        info.addSubplotInfo(subplotInfo);
    }

    if(i==getSubplots().size()-1){  // If the last row
        for(int j=0; j < plot.getSubplots().size(); j++)
            ((XYPlot)plot.getSubplots().get(j)).getDomainAxis().setVisible(true);
    }

    plot.draw(g2, this.subplotAreas[i], anchor, parentState, subplotInfo);

    if(i==getSubplots().size()-1){  // If the last row
        for(int j=0; j < plot.getSubplots().size(); j++)
            ((XYPlot)plot.getSubplots().get(j)).getDomainAxis().setVisible(false);
    }
}