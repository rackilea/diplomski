@Override
protected void onDraw(Canvas canvas) {
    for (String key : map.keySet()) {
        Path path = map.get(key);
        canvas.drawPath(path, paint);
    }
}