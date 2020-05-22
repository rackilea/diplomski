mDataSet.setCircleColorHole(color);
int circleColor= mDataSet.getCircleColors().get(0);
int colorCount = mDataSet.getCircleColors().size();
mDataSet.resetCircleColors();
mDataSet.setCircleColor(circleColor);
if(colorCount==1){mDataSet.getCircleColors().add(circleColor);}