canvas.setOnMousePressed(event -> {
    for (IGameObject current : drop) {
        if(current.insideBounds(event.getX(), event.getY())) {
            current.slice();
        }
    }
});