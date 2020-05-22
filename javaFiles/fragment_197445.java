String g = geolocation.getValue();
try {
    Geometry fr = new PGgeometry().geomFromString(g);
    Point p = fr.getPoint(0);
    this.geolocation = p;
} catch (SQLException e) {
    e.printStackTrace();
}