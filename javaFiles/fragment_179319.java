double newMeasure = (userImage.getImage().getWidth() < userImage.getImage().getHeight()) ? userImage.getImage().getWidth() : userImage.getImage().getHeight();
double x = (userImage.getImage().getWidth() - newMeasure) / 2;
double y = (userImage.getImage().getHeight() - newMeasure) / 2;

Rectangle2D rect = new Rectangle2D(x, y, newMeasure, newMeasure);
userImage.setViewport(rect);
userImage.setFitWidth(150);
userImage.setFitHeight(150);
userImage.setSmooth(true);