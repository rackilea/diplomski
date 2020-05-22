// Create style for the line
    // Style style = SLD.createSimpleStyle(TYPE, Color.red);
    org.geotools.styling.Style style = SLD.createLineStyle(Color.red, 2.0f);
    StyleBuilder sb = new StyleBuilder();
    FilterFactory2 ff = CommonFactoryFinder.getFilterFactory2();
    PointSymbolizer point = sb.createPointSymbolizer();
    Mark mark = sb.createMark("shape://oarrow");
    mark.setFill(sb.createFill(Color.RED));
    mark.setStroke(sb.createStroke(Color.red));

    Graphic graphic = sb.createGraphic(null, mark, null);
    graphic.setRotation(ff.function("endAngle", ff.property("line")));
    point.setGraphic(graphic);

    point.setGeometry(ff.function("endpoint", ff.property("line")));

    Rule rule = sb.createRule(point);
    style.getFeatureTypeStyles()[0].addRule(rule );
    Layer layer = new FeatureLayer(featureCollection, style);