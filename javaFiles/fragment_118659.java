public void onDraw(Canvas canvas) {
    Path path = new Path();

    if(points.size() > 1){
        for(int i = points.size() - 2; i < points.size(); i++){
            if(i >= 0){
                Point point = points.get(i);

                if(i == 0){
                    Point next = points.get(i + 1);
                    point.dx = ((next.x - point.x) / 3);
                    point.dy = ((next.y - point.y) / 3);
                }
                else if(i == points.size() - 1){
                    Point prev = points.get(i - 1);
                    point.dx = ((point.x - prev.x) / 3);
                    point.dy = ((point.y - prev.y) / 3);
                }
                else{
                    Point next = points.get(i + 1);
                    Point prev = points.get(i - 1);
                    point.dx = ((next.x - prev.x) / 3);
                    point.dy = ((next.y - prev.y) / 3);
                }
            }
        }
    }

    boolean first = true;
    for(int i = 0; i < points.size(); i++){
        Point point = points.get(i);
        if(first){
            first = false;
            path.moveTo(point.x, point.y);
        }
        else{
            Point prev = points.get(i - 1);
            path.cubicTo(prev.x + prev.dx, prev.y + prev.dy, point.x - point.dx, point.y - point.dy, point.x, point.y);
        }
    }
    canvas.drawPath(path, paint);
}