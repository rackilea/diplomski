class Canvas {
    private ConnectionManager connectionManager = new ConnectionManager();

    private Set<Shape> shapes = new HashSet<Shape>();

    public Canvas() {
    }

    public void removeShape(Shape shape) {
        if (!shapes.remove(shape))
            return; 

        if (shape.getClass().isAnnotationPresent(CascadeDeleteConnectedShapes.class)) {
            cascadeDeleteShape(shape);
        }

        if (shape instanceof ShapeConnection) {
            connectionManager.remove((ShapeConnection) shape);
        }
    }

    private void cascadeDeleteShape(Shape shape) {
        List<ShapeConnection> connections = connectionManager.getConnections(shape);
        for (ShapeConnection connection : connections) {
            if (connection instanceof Shape) {
                this.removeShape((Shape) connection);
            } else {
                connectionManager.remove(connection);
            }
        }
    }

    public void addShape(Shape shape) {
        if (shapes.contains(shape))
            return;

        if (shape instanceof ShapeConnection) {
            addShapeConnection((ShapeConnection) shape);
        }

        shapes.add(shape);
    }

    private void addShapeConnection(ShapeConnection shapeConnection) {
        for (Shape shape : shapeConnection.getConnectedShapes()) {
            if (!shapes.contains(shape))
                throw new Error("cannot connect unknown shapes");
        }
        connectionManager.add(shapeConnection);
    }
}