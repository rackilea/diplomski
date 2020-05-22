Anchor start = new Anchor(Color.PALEGREEN, startX, startY);
Anchor end   = new Anchor(Color.TOMATO,    endX,   endY);

Center startCenter = new Center(start);
Center endCenter   = new Center(end);

Line line = new BoundLine(
        startCenter.centerXProperty(),
        startCenter.centerYProperty(),
        endCenter.centerXProperty(),
        endCenter.centerYProperty()
);