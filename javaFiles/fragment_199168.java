String fontPath = "c:\\...\\font.ttf"; // Path to font file
ArrayList<PVector> edgeVertices = new ArrayList<>();
PFont font = createFont(fontPath, 96, true);
PShape shape = font.getShape(char c);
for (int i = 0; i < shape.getVertexCount(); i++) {
    boundaryVertices.add(shape.getVertex(i));
}