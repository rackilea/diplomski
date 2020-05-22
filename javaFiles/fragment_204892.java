stage.initStyle(StageStyle.UNDECORATED);

Rectangle2D bounds = Screen.getPrimary().getVisualBounds();

stage.setX(bounds.getMinX());
stage.setY(bounds.getMinY());
stage.setWidth(bounds.getWidth());
stage.setHeight(bounds.getHeight());

stage.show();