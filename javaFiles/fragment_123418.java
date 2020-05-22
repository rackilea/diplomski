shapeRenderer.begin(ShapeType.Line);
shapeRenderer.identity();
shapeRenderer.translate(20, 12, 2);
shapeRenderer.rotate(0, 0, 1, 90);
shapeRenderer.rect(-width / 2, -height / 2, width, height);
shapeRenderer.end();