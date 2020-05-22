Line2D line = new Line2D.Double(x0, y0, x1, y1);

    double distance = line.ptLineDist(px, py);

    if (Math.abs(distance) < threshold) {
              // is Near line
    }