public void update(Graphics g, JComponent c) {
    SynthContext context = getContext(c);

    SynthLookAndFeel.update(context, g);
    context.getPainter().paintTextAreaBackground(context,
                      g, 0, 0, c.getWidth(), c.getHeight());
    paint(context, g);
    context.dispose();
}