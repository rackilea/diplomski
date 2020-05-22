// adapted from http://docs.geotools.org/stable/userguide/library/referencing/calculator.html
CoordinateReferenceSystem crs = CRS.decode("EPSG:4326");
GeodeticCalculator gc = new GeodeticCalculator(crs);
gc.setStartingPosition( JTS.toDirectPosition(  DistanceOp.closestPoints(geo, p)[0], crs ) );
gc.setDestinationPosition( JTS.toDirectPosition( p, crs ) );

double distance = gc.getOrthodromicDistance();