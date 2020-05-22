final SimpleFeatureTypeBuilder pointTb = new SimpleFeatureTypeBuilder();
pointTb.setName("points");
pointTb.setCRS(DefaultGeographicCRS.WGS84);
pointTb.add("point", Point.class);
pointTb.add("color", String.class);
pointTb.add("size", Integer.class);
pointTb.add("opacity", Float.class);
final SimpleFeatureBuilder pointFeatureBuilder = new SimpleFeatureBuilder(pointTb.buildFeatureType());