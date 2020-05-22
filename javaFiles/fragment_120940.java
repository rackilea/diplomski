StyleBuilder sb = new StyleBuilder();
FilterFactory2 ff = sb.getFilterFactory();

Mark testMark = sb.createMark(sb.literalExpression("Circle"), 
    sb.createFill(sb.attributeExpression("color"),sb.attributeExpression("opacity")),
        null);
Graphic graph = sb.createGraphic(null, // An external graphics if needed
        new Mark[] { testMark }, // a Mark if not an external graphics
        null, // aSymbol
        ff.literal(sb.attributeExpression("opacity")), // opacity
        ff.property("size"), // read from feature "size" attribute
        ff.literal(0)); // rotation, here read into the feature
PointSymbolizer aPointSymbolizer = sb.createPointSymbolizer(graph);

// creation of the style
org.geotools.styling.Style style = sb.createStyle(aPointSymbolizer);