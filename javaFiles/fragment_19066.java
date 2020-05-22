private Kart m;
private VisibilityMap visibilities;
...
m = new Kart();
p = new Spiller();
visibilities = new VisibilityMap(m.getTileSizeX(), m.getTileSizeY());
visibilities.updateVisibilityAround(p.getTileX(), p.getTileY());