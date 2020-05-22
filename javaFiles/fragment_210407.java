Graphics2D graphics2D = (Graphics2D) g_;

graphics2D.setRenderingHint(
        RenderingHints.KEY_ANTIALIASING,
        RenderingHints.VALUE_ANTIALIAS_ON);

graphics2D.drawLine(_x, _y, _x+_w, _y+_h);
graphics2D.drawLine(_x, _y+_h, _x+_w, _y);