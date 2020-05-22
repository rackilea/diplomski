// your existing code

double sceneX = textField.getScene().getX();
double sceneY = textField.getScene().getY();

resultsList.show(textField, x + textFieldBounds.getMinX() + sceneX,
    y + textFieldBounds.getMaxY() + sceneY);