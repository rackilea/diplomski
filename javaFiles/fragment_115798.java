GeneralPath path = new GeneralPath();
path.lineTo(10, 10);
path.lineTo(0, 10);
path.lineTo(0, 0);
graphics.setColor(Color.RED);
graphics.fill(path);