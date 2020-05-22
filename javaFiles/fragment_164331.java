JViewport viewport = (JViewport) table.getParent();
Rectangle r = table.getCellRect(rowIndex, 0, true);
int extentHeight = viewport.getExtentSize().height;
int viewHeight = viewport.getViewSize().height;

int y = Math.max(0, r.y - ((extentHeight - r.height) / 2));
y = Math.min(y, viewHeight - extentHeight);

viewport.setViewPosition(new Point(0, y));