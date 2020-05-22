Display display = getWindowManager().getDefaultDisplay();
Point size = new Point();
display.getSize(size);
int width = size.x;
int height = size.y;

popupWindow.setWidth(width-10);
popupWindow.setHeight(height-10);