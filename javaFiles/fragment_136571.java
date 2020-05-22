batch.setShader(shaderOutline);
batch.begin();
batch.draw(img, 240, 400);
batch.end();
batch.setShader(null);
// Add this:
batch.begin();
batch.draw(img, 240, 400);
batch.end();