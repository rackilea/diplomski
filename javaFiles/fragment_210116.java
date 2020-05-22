public Envelope getEnvelope() {
  if (base != null) {
    return new Envelope(base.x, base.x + width, base.y, base.y + height);
  }
  ...
}