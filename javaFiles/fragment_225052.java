boolean first = true;
    for(int i = 0; i < points.size(); i++){
        Point point = points.get(i);

        for (int index = 0; index <= startValues.size() - 1; index++){
            if (i == startValues.get(index)){
                lineChange = true;
                endNumber = (startValues.get(index) - 1);
                break;
            }
        }

        if(first || lineChange){
            first = false;
            lineChange = false;
            path.moveTo(point.x, point.y);
        }else{
            Point prev = points.get(i - 1);
            path.cubicTo(prev.x + prev.dx, prev.y + prev.dy, point.x - point.dx, point.y - point.dy, point.x, point.y);
        }

    }

    canvas.drawPath(path, paint);