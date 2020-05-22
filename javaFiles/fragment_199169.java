strokeWeight(2);
beginShape();
for (PVector v : edgeVertices) {
    vertex(v.x + 55, v.y + 125);
}
endShape(CLOSE);