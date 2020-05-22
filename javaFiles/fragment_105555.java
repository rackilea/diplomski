class TextContainer extends JPanel
{
    private int m_width;
    private int m_height;
    private String m_text;
    private AttributedCharacterIterator m_iterator;
    private int m_start;
    private int m_end;

    public TextContainer(String text, int width, int height)
    {
        m_text = text;
        m_width = width;
        m_height = height;

        AttributedString styledText = new AttributedString(text);
        m_iterator = styledText.getIterator();
        m_start = m_iterator.getBeginIndex();
        m_end = m_iterator.getEndIndex();
    }

    public String getText()
    {
        return m_text;
    }

    public Dimension getPreferredSize()
    {
        return new Dimension(m_width, m_height);
    }

    public void paint(Graphics g)
    {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        FontRenderContext frc = g2.getFontRenderContext();

        LineBreakMeasurer measurer = new LineBreakMeasurer(m_iterator, frc);
        measurer.setPosition(m_start);

        float x = 0, y = 0;
        while (measurer.getPosition() < m_end)
        {
            TextLayout layout = measurer.nextLayout(m_width);

            y += layout.getAscent();
            float dx = layout.isLeftToRight() ?
                    0 : m_width - layout.getAdvance();

            layout.draw(g2, x + dx, y);
            y += layout.getDescent() + layout.getLeading();
        }
    }
}