void draw() {
    super.draw();
    polyBatch.begin();
    poly.draw(polyBatch);
    polyBatch.end();
    poly.rotate(1.1f);
}