public interface DrawOperation {
    void draw(GraphicsContext gc);
}

public class DrawBoard {
    private final List<DrawOperation> operations = new ArrayList<>();
    private final GraphicsContext gc;
    private int historyIndex = -1;

    public DrawBoard(GraphicsContext gc) {
        this.gc = gc;
    }

    public void redraw() {
        Canvas c = gc.getCanvas();
        gc.clearRect(0, 0, c.getWidth(), c.getHeight());
        for (int i = 0; i <= historyIndex; i++) {
            operations.get(i).draw(gc);
        }
    }

    public void addDrawOperation(DrawOperation op) {
        // clear history after current postion
        operations.subList(historyIndex+1, operations.size()).clear();

        // add new operation
        operations.add(op);
        historyIndex++;
        op.draw(gc);
    }

    public void undo() {
        if (historyIndex >= 0) {
            historyIndex--;
            redraw();
        }
    }

    public void redo() {
        if (historyIndex < operations.size()-1) {
            historyIndex++;
            operations.get(historyIndex).draw(gc);
        }
    }
}

class EllipseDrawOperation implements DrawOperation {

    private final double minX;
    private final double minY;
    private final double width;
    private final double height;
    private final Paint stroke;

    public EllipseDrawOperation(double minX, double minY, double width, double height, Paint stroke) {
        this.minX = minX;
        this.minY = minY;
        this.width = width;
        this.height = height;
        this.stroke = stroke;
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setStroke(stroke);
        gc.strokeOval(minX, minY, width, height);
    }

}