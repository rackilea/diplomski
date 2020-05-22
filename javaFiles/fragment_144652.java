@Override
public Paint getItemPaint(int series, int category) {
  if (category == 4)
    return this.colors2[series % this.colors1.length];
  else
    return this.colors1[series % this.colors1.length];
}