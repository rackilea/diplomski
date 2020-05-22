case LineChart:
    g2.setColor(lineColor);
    path.moveTo(xChartToScreen(xData[0]),
        yChartToScreen(yData[0]));
    for (int k = 1; k < dataLength; k++)
      path.lineTo(xChartToScreen(xData[k]),
          yChartToScreen(yData[k]));
    g2.draw(path);
    break;

  case ColumnChart:
    for (int k = 0; k < dataLength; k++) {
      xMax++;
      int x = xChartToScreen(xData[k]);
      int w = columnWidth;
      int y1 = yChartToScreen(yData[k]);
      int y = Math.min(y0, y1);
      int h = Math.abs(y1 - y0);
      Shape rc = new Rectangle2D.Double(x, y, w, h);
      path.append(rc, false);
      xMax--;
    }

    if (drawShadow) {
      AffineTransform s0 = new AffineTransform(1.0, 0.0, 0.0,
          -1.0, x0, y0);
      s0.concatenate(AffineTransform.getScaleInstance(1.0, 0.5));
      s0.concatenate(AffineTransform.getShearInstance(0.5, 0.0));
      s0.concatenate(new AffineTransform(1.0, 0.0, 0.0, -1.0,
          -x0, y0));
      g2.setColor(Color.gray);
      Shape shadow = s0.createTransformedShape(path);
      g2.fill(shadow);
    }

    if (m_effectIndex == Gradientffect && gradient != null) {
      g2.setPaint(gradient);
      g2.fill(path);
    } else if (m_effectIndex == ImageEffect
        && foregroundImage != null)
      fillByImage(g2, path, 0);
    else {
      g2.setColor(columnColor);
      g2.fill(path);
    }
    g2.setColor(lineColor);
    g2.draw(path);
    break;