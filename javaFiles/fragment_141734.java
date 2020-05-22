Button bt;

Bounds localBounds = bt.localToScene(bt.getBoundsInLocal());

double popupX = bt.getScene().getWindow().getX() + localBounds.getMaxX();
double popupY = bt.getScene().getWindow().getY() + localBounds.getMaxY();