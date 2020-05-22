XYPolygonAnnotation a = new XYPolygonAnnotation(new double[]{2.0,
            5.0, 2.5, 8.0, 3.0, 5.0, 2.5, 2.0}, null, null,
                new Color(plotBackground.getRed(), plotBackground.getGreen(),
             plotBackground.getBlue(), 255)) {

            @Override
            public void draw(Graphics2D g2, XYPlot plot, Rectangle2D dataArea, ValueAxis domainAxis, ValueAxis rangeAxis, int rendererIndex, PlotRenderingInfo info) {
                Graphics2D g22 = (Graphics2D) g2.create();
                g22.setXORMode(new Color(0xff0000));
                super.draw(g22, plot, dataArea, domainAxis, rangeAxis, rendererIndex, info); 
            }
        };

renderer.addAnnotation(a,  Layer.BACKGROUND);