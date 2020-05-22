private void makePolyScale(int height, int width) {

    Scale scale = new Scale ();
    scale.setX(width/BASE_WIDTH);
    scale.setY(height/BASE_HEIGHT);

    scale.setPivotX(this.body.getBoundsInParent().getCenterX());
    scale.setPivotY(this.body.getBoundsInParent().getCenterY());

    body.getTransforms().addAll(scale);
}