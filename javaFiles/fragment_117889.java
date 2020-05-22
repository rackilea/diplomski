PolygonShape shape = (PolygonShape) fixture.getShape();
int vertexCount = shape.getVertexCount();
float[] vertices = new float[vertexCount * 2];
for (int k = 0; k < vertexCount; k++) {
    shape.getVertex(k, mTmp);
    mTmp.rotate(body.getAngle()* MathUtils.radiansToDegrees);
    mTmp.add(bodyPos); 
    vertices[k * 2] = mTmp.x * PIXELS_PER_METER;
    vertices[k * 2 + 1] = mTmp.y * PIXELS_PER_METER;
}
short triangles[] = new EarClippingTriangulator()
        .computeTriangles(vertices)
        .toArray();
PolygonRegion region = new PolygonRegion(
        textureRegion, vertices, triangles);