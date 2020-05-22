@Override
protected void paintComponent(Graphics g) {
    super.paintComponent(g);  // do housekeeping painting

    // note that I've renamed the array to gameObjectArray
    for (GameObject gameObject : gameObjectArray) {
        gameObject.paint(g);  // this is all you need to call
    }
}