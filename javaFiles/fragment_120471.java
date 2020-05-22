int lastY = yBase - (int) (getValue(0)*graphHeight / maxY * yScale);
        for (int i = 1; i < 360; i++) {

            x = xBase + i;
            y = yBase - (int) (getValue(i)*graphHeight / maxY * yScale);
            g.drawLine(x-1, lastY, x-1, (y+lastY)/2);
            g.drawLine(x, (y+lastY)/2, x, y);

        }