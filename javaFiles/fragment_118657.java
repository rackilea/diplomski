public void onDraw(Canvas canvas) {
    Path path = new Path();
    boolean first = true;
    for(Point point : points){
        if(first){
            first = false;
            path.moveTo(point.x, point.y);
        }
        else{
            path.lineTo(point.x, point.y);
        }
    }
    canvas.drawPath(path, paint);
}