PolygonBuilder builder = Polygon.Builder();

for (int i = 0; i < vertices.length; i++) {
    builder = builder.addVertex(new Point(vertices[i].getX(), vertices[i].getY());
}

Polygon polygon = builder.build();