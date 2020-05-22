public void onDraw(Canvas canvas) {
    Path path = new Path();
    boolean first = true;
    for(int i = 0; i < points.size(); i += 2){
        Point point = points.get(i);
        if(first){
            first = false;
            path.moveTo(point.x, point.y);
        }

        else if(i < points.size() - 1){
            Point next = points.get(i + 1);
            path.quadTo(point.x, point.y, next.x, next.y);
        }
        else{
            path.lineTo(point.x, point.y);
        }
    }

    canvas.drawPath(path, paint);
}