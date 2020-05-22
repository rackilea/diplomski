private static class PointBuilderWithY extends PointBuilder {
  @Override
  PointBuilderWithY withX(double x) {
    return (PointBuilderWithY) super.withX(x);
  }

  PointBuilderWithY withY(double y) {
    this.y = y;
    return this;
  }
}