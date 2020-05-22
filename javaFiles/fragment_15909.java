// Because we're about to spin this triangle, be sure to draw
    // backfaces.  If we don't, the back side of the triangle is invisible.
    Appearance ap = new Appearance();
    PolygonAttributes pa = new PolygonAttributes();
    pa.setCullFace(PolygonAttributes.CULL_NONE);
    ap.setPolygonAttributes(pa);
    shape.setAppearance(ap);