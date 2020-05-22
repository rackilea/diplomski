public class StringBoundsPanel extends JPanel
{
    public StringBoundsPanel()
    {
        setBackground(Color.white);
        setPreferredSize(new Dimension(400, 247));
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                            RenderingHints.VALUE_ANTIALIAS_ON);

        // must be called before getStringBounds()
        g2.setFont(getDesiredFont());

        String str = "My Text";
        float x = 140, y = 128;

        Rectangle bounds = getStringBounds(g2, str, x, y);

        g2.setColor(Color.red);
        g2.drawString(str, x, y);

        g2.setColor(Color.blue);
        g2.draw(bounds);

        g2.dispose();
    }

    private Rectangle getStringBounds(Graphics2D g2, String str,
                                      float x, float y)
    {
        FontRenderContext frc = g2.getFontRenderContext();
        GlyphVector gv = g2.getFont().createGlyphVector(frc, str);
        return gv.getPixelBounds(null, x, y);
    }

    private Font getDesiredFont()
    {
        return new Font(Font.SANS_SERIF, Font.BOLD, 28);
    }

    private void startUI()
    {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(this);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) throws Exception
    {
        final StringBoundsPanel tb = new StringBoundsPanel();

        SwingUtilities.invokeAndWait(new Runnable()
        {
            public void run()
            {
                tb.startUI();
            }
        });
    }
}