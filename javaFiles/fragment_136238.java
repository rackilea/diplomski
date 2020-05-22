oldIndex = -1;
    tChart1.getAspect().setView3D(false);
    tChart1.getLegend().setVisible(false);

    ColorGrid col1 = new ColorGrid(tChart1.getChart());
    col1.setColorEach(true);
    for (int x=0; x<10; x++)
        for (int z=0; z<10; z++)
            col1.add(x, 1, z, Color.random());

    col1.addSeriesMouseListener(new SeriesMouseAdapter() {      
        @Override
        public void seriesClicked(SeriesMouseEvent e) {
            ColorGrid myGrid = (ColorGrid)tChart1.getSeries(0);
            int valueIndex = myGrid.clicked(e.getPoint().x, e.getPoint().y);
            if (valueIndex > -1) { 
                if (oldIndex > -1) {
                    myGrid.getColors().setColor(oldIndex, oldColor);
                }
                oldIndex = valueIndex;
                oldColor = myGrid.getValueColor(valueIndex);
                myGrid.getColors().setColor(valueIndex, Color.red);
                tChart1.getHeader().setText(String.valueOf(valueIndex));
                tChart1.getSeries(0).repaint();
            }
        }
});