public class frame extends JFrame {
    private int lines;    // private for encapsulation. getter/setter below
    ...
    panelWithButton panel = new panelWithButton(frame.this);
    ...
    public void setLines(int lines) {
        this.lines = lines;
    }
}

public class panelWithButton extends JPanel {
    private frame f;

    public panelWithButton(final frame f) {
        this.f = f;
    }

    public void button() {
        ...
        public void actionPerformed(ActionEvent e) {
            f.setLines(5);
        }
    }
}