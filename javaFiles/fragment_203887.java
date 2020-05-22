ImageView imageView = new ImageView(image);
imageView.setViewport(rectInSource);

// ----------- Only required, if rescaling is desired -----------
imageView.setFitWidth(targetRect.getWidth());
imageView.setFitHeight(targetRect.getHeight());
// --------------------------------------------------------------

imageView.relocate(targetRect.getMinX(), targetRect.getMinY());
pane.getChildren().add(imageView);