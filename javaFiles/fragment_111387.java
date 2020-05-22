Vector2 point = new Vector2();
for (int i = 0; i <= 100; i++) {

    curve.valueAt(point, i * 0.01f);

    // draw using point.x and point.y
}