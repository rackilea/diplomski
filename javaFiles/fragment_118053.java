List<GeometricObject> geoList = new ArrayList<GeometricObject>();
while(diskScanner.hasNext()){
    String list = diskScanner.nextLine();
    g = recreateObject(list);

    geoList.add(g);

}