public class FrameBuilder {

    private String title;
    private int closeOperation;
    private boolean resizable;

    public FrameBuilder() {
        closeOperation = JFrame.DISPOSE_ON_CLOSE;
        resizable = false;
    }

    public FrameBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    public FrameBuilder setDefaultCloseOperation(int op) {
        this.closeOperation = op;
        return this;
    }

    public FrameBuilder setResizable(boolean resizable) {
        this.resizable = resizable;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public boolean isResizable() {
        return resizable;
    }

    public int getCloseOperation() {
        return closeOperation;
    }

    public JFrame build() {
        JFrame frame = new JFrame(getTitle());
        frame.setResizable(isResizable());
        frame.setDefaultCloseOperation(getCloseOperation());
        return frame;
    }

}