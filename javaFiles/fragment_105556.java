public void paint(Graphics g)
{
    super.paintComponent(g);

    Graphics2D g2 = (Graphics2D) g;
    FontRenderContext frc = g2.getFontRenderContext();

    LineBreakMeasurer measurer = new LineBreakMeasurer(m_iterator, frc);
    measurer.setPosition(m_start);

    float y = 0;
    while (measurer.getPosition() < m_end)
    {
        double ix = Math.sqrt((m_width / 2 - y) * y);
        float x = m_width / 2.0F - (float) ix;
        int width = (int) ix * 2;

        TextLayout layout = measurer.nextLayout(width);

        y += layout.getAscent();
        float dx = layout.isLeftToRight() ?
                0 : width - layout.getAdvance();

        layout.draw(g2, x + dx, y);
        y += layout.getDescent() + layout.getLeading();
    }
}