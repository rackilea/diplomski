shapeRenderer.begin(ShapeType.Line);
 shapeRenderer.setColor(1, 1, 0, 1);
 shapeRenderer.line(x, y, x2, y2);
 shapeRenderer.rect(x, y, width, height);
 shapeRenderer.circle(x, y, radius);
 shapeRenderer.end();

 shapeRenderer.begin(ShapeType.Filled);
 shapeRenderer.setColor(0, 1, 0, 1);
 shapeRenderer.rect(x, y, width, height);
 shapeRenderer.circle(x, y, radius);
 shapeRenderer.end();