public class Mycaret extends DefaultCaret {

    protected static final int MIN_WIDTH = 8;

    public Mycaret(int rate) {

        super.setBlinkRate(rate);
    }

    protected boolean isBeforeNewLine() throws BadLocationException {

        PlainDocument doc = (PlainDocument) getComponent().getDocument();
        if (doc.getText(getDot(), 1).equals("\n"))
            return true;
        return false;
    }

    @Override
    protected synchronized void damage(Rectangle r) {

        if (r != null) {
            try {
                JTextComponent comp = getComponent();

                Rectangle r2 = comp.getUI().modelToView(comp, getDot() + 1);
                int width = r2.x - r.x;
                if (width == 0 || isBeforeNewLine()) {
                    width = MIN_WIDTH;
                }
                comp.repaint(r.x, r.y, width, r.height);

                this.x = r.x;
                this.y = r.y;
                this.width = width;
                this.height = r.height;
            } catch (BadLocationException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void paint(Graphics g) {

        if (isVisible()) {
            try {
                JTextComponent comp = getComponent();

                g.setColor(comp.getForeground());
                g.setXORMode(comp.getBackground());

                Rectangle r1 = comp.getUI().modelToView(comp, getDot());
                Rectangle r2 = comp.getUI().modelToView(comp, getDot() + 1);
                int width = r2.x - r1.x;
                if (width == 0 || isBeforeNewLine()) {
                    width = MIN_WIDTH;
                }
                g.fillRect(r1.x, r1.y, width, r1.height);
            } catch (BadLocationException e) {
                e.printStackTrace();
            }
        }
    }
}