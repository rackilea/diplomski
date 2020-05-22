public class Facebook_Graphics {
    private String name;
    private String content;
    DrawableFrame df;
    private Graphics g;

    public Facebook_Graphics(String nm) {
        content = "undefined";
        name = nm;

        // Create drawable frame        
        df = new DrawableFrame(name);
        df.show();
        df.setSize(200, 150);

        // Obtain graphics context
        g = df.getGraphicsContext();
        drawLayout();
        df.repaint();
    }

    public void setContent(String newContent) {
        content = newContent;

        clearGraphics();
        drawLayout();

        // Repaint frame
        df.repaint();
    }
    private void clearGraphics() {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, 200, 150);
    }
    private void drawLayout() {
        g.setColor(Color.BLACK);
        g.drawString("Name", 20, 40);
        g.drawString("Mood", 20, 90);

        g.setColor(Color.GREEN);
        g.fillRect(80, 20, 100, 30);

        g.setColor(getMoodColor());
        g.fillRect(80, 70, 100, 30);

        g.setColor(Color.BLACK);
        g.drawString(name, 90, 40);
        g.drawString(content, 90, 90);
    }

    private Color getMoodColor() {
        return "happy".equals(content) ? Color.RED : Color.GRAY;
    }

    public String getContent() {
        return content;
    }
}