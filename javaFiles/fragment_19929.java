public void onDraw(Canvas c) {
    Bubble b = new Bubble();
    p.setColor(b.getColor());
    p.setStyle(Paint.Style.FILL);
    bList.add(b);
    c.drawCircle(b.getX(), b.getY(), b.getR(), p);  // c == null here!
}