public SimpleFeature bufferFeature(SimpleFeature feature, Measure<Double, Length> distance) {
    // extract the geometry
    GeometryAttribute gProp = feature.getDefaultGeometryProperty();
    CoordinateReferenceSystem origCRS = gProp.getDescriptor().getCoordinateReferenceSystem();

    Geometry geom = (Geometry) feature.getDefaultGeometry();
    Geometry pGeom = geom;
    MathTransform toTransform, fromTransform = null;
    // reproject the geometry to a local projection
    if (!(origCRS instanceof ProjectedCRS)) {

      double x = geom.getCoordinate().x;
      double y = geom.getCoordinate().y;

      String code = "AUTO:42001," + x + "," + y;
      // System.out.println(code);
      CoordinateReferenceSystem auto;
      try {
        auto = CRS.decode(code);
        toTransform = CRS.findMathTransform(DefaultGeographicCRS.WGS84, auto);
        fromTransform = CRS.findMathTransform(auto, DefaultGeographicCRS.WGS84);
        pGeom = JTS.transform(geom, toTransform);

      } catch (MismatchedDimensionException | TransformException | FactoryException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }

    }