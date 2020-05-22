RoundRectShape rect = new RoundRectShape(
  new float[] {30,30, 30,30, 30,30, 30,30},
  null,
  null);
ShapeDrawable bg = new ShapeDrawable(rect);
bg.getPaint.setColor(0x99FFFFFF);
view.setBackgroundDrawable(bg);