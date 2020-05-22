public static void adjust(GlyphVector gv){
    // calc the adjust Factor
    int adjust = (int)Math.round(gv.getGlyphVisualBounds(0).getBounds2D().getMinX());
    // Shift all the Glyphs in Vector
    for (int i = 0; i < gv.getNumGlyphs(); i++) {
        Point2D point = gv.getGlyphPosition(i);
        gv.setGlyphPosition( i, new Point2D.Double(
            point.getX() - adjust, 
            point.getY()));         
    }
}