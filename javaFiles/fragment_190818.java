CoordinateReferenceSystem crs = null;
try {

    crs = CRS.decode("epsg:26910");
    System.out.println("got "+crs);

} catch (FactoryException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}