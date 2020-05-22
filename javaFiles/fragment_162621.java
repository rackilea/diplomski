MapTypeStyler styler = new MapTypeStyler();
styler.setVisibility("off");

MapTypeStyle style = new MapTypeStyle();
style.setElementType(MapTypeStyleElementType.ALL);
style.setFeatureType(MapTypeStyleFeatureType.POI);
style.setStylers(new MapTypeStyler[]{styler});

StyledMapType styledMap = new StyledMapType(map, new MapTypeStyle[]{style});
map.mapTypes().set("newStyle", styledMap);
map.setMapTypeId(new MapTypeId("newStyle"));