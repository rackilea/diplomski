String[] wkt = {
    "Point (-0.13666168754467312 50.81919869153657743)",
    "Point (-0.13622277073931291 50.82205165077141373)",
    "Point (-0.13545466632993253 50.82512406840893959)",
    "Point (-0.13457683271921211 50.82687973563037787)",
    "Point (-0.13413791591385191 50.82907431965718104)",
    "Point (-0.13951464677951447 50.8294035072611976)",
    "Point (-0.14346489802775639 50.83082998687861931)",
    "Point (-0.14697623247063807 50.83072025767727808)",
    "Point (-0.15004865010815954 50.83390240451614517)",
    "Point (-0.15740050659794308 50.8349996965295432)",
    "Point (-0.16486209228906662 50.83741373895902171)",
    "Point (-0.17276259478555042 50.83894994777778464)",
    "Point (-0.18549118214099652 50.8387304893751022)"
    };

    //build line
    WKTReader2 reader = new WKTReader2();
    GeometryFactory gf = new GeometryFactory();
    Coordinate[] points = new Coordinate[wkt.length];
    int i=0;
    for(String w:wkt) {
      Point p;
  try {
    p = (Point) reader.read(w);
    points[i++]=p.getCoordinate();
  } catch (ParseException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
  }

    }
    LineString line = gf.createLineString(points);
    SimpleFeatureBuilder builder = new SimpleFeatureBuilder(schema);
    builder.set("locations", line);
    SimpleFeature feature = builder.buildFeature("1");