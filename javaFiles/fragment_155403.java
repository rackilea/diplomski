public Shape getShape() {
    final Ellipse2D.Double result = new Ellipse2D.Double();
    final double px = Math.min(getStart().getX(), getEnd().getX());
    final double py = Math.min(getStart().getY(), getEnd().getY());
    final double pw = Math.abs(getStart().getX() - getEnd().getX());
    result.setFrame(px, py, pw, pw);
    return result;
}