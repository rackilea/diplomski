double[] labelAngles = new double[getData().size()];
double scale = (total != 0) ? 360 / total : 0;
double start = getStartAngle();

int index = 0;
for (Data d : getData()){
  double size = (isClockwise()) ? (-scale * Math.abs(item.getCurrentPieValue())) : (scale * Math.abs(item.getCurrentPieValue()));
  labelAngles[index] = normalizeAngle(start + (size / 2));
  double sliceX = calcX(labelAngles[index], pieRadius * 0.7, centerX);
  double sliceY = calcY(labelAngles[index], pieRadius * 0.7, centerY);
  //Note: to place it in perfect center:
  //sliceX = sliceX - (text.getBoundsInLocal().getWidth() / 2;
  //sliceY = sliceY - (text.getBoundsInLocal().getHeight() / 2;
  text.relocate(sliceX, sliceY);
}