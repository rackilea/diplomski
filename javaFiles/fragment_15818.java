return (
  x.doubleValue() + w.doubleValue() >= x0.doubleValue() &&
  y.doubleValue() - h.doubleValue() <= y0.doubleValue() &&     
  x0.doubleValue() + getWidth().doubleValue() >= x.doubleValue() &&
  y0.doubleValue() - getHeight().doubleValue() <= y.doubleValue()
);