public void calcThreatCircleOnScreen(UnfoldingMap map) {
    float radius = 0;
    Location centerLocation = this.getLocation();
    Location upperLocation = GeoUtils.getDestinationLocation(centerLocation, 0, threatCircle());

    //SimplePointMarker upperMarker = new SimplePointMarker(upperLocation);

    ScreenPosition center = map.getScreenPosition(centerLocation);
    ScreenPosition upper = map.getScreenPosition(upperLocation);
    radius = PApplet.dist(center.x, center.y, upper.x, upper.y);        
    setThreatCircleOnScreen(radius);