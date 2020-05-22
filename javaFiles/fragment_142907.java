for (Iterator<Map.Entry<Double, Polygon>> it = sortedPolygons.entrySet().iterator(); it.hasNext(); ) {
    Map.Entry<Double, Polygon> entry = it.next();
    if (entry.getValue().getExteriorRing().equals(hole)) {
        it.remove();
        // if you want to exit the loop as soon as you found a match:
        break;
    }
}