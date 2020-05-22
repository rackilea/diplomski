Stroke defaultStroke;

    Graphics2D g2d = (Graphics2D) g.create();

    defaultStroke = g2d.getStroke();
    //
    //do your thing
    //
    //reset by
    g2d.setStroke(defaultStroke);