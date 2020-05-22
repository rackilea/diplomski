try(SimpleFeatureIterator itr1 = features.features()){
  while(itr1.hasNext()){
     SimpleFeature f = itr1.next();
     Geometry g = (Geometry)f.getDefaultGeometry();
     Coordinate[] coords = g.getCoordinates();
     // do something with the coordinates
   }
}