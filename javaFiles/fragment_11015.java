//Shape polyShape = new Polygon(SHAPE_X, SHAPE_Y, SHAPE_X.length);
//Piece topLeft = new Piece(Color.YELLOW, polyShape,   0, 100, 100);
Polygon topLeftPolygon = new Polygon(SHAPE_X, SHAPE_Y, SHAPE_X.length);
topLeftPolygon.translate(100, 100);
//topLeftPolygon = ShapeUtils.rotate(...); // do rotation when required
Piece topLeft = new Piece(Color.YELLOW, topLeftPolygon);