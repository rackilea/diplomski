multiplier = ratio62Value + i;
            diffx = (stop.getX() - start.getX()) * multiplier;
            diffy = (stop.getY() - start.getY()) * multiplier;
            xValue = start.getX() + diffx;
            yValue = start.getY() + diffy;
            point = new Point(xValue, yValue);
            line = new Line(point, stop);
            line.calculateCirclePoints();