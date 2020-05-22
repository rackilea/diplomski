@SuppressWarnings("serial")
class BorderEffect2 extends AbstractBorder implements Border {
    public static final int TIMER_DELAY = 10;
    private int i = 0;
    private JPanel testPanel;
    private Color color;
    private Timer timer;

    public BorderEffect2(JPanel testPanel, Color color) {
        this.testPanel = testPanel;
        this.color = color;

        testPanel.addMouseListener(new MouseAdapt());
    }

    private class MouseAdapt extends MouseAdapter {
        @Override
        public void mouseEntered(MouseEvent e) {
            if (timer != null && timer.isRunning()) {
                return;
            }
//            System.out.println("here");
            timer = new Timer(TIMER_DELAY, new TimerListener());
            timer.start();
        }
    }

    private class TimerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            i++;
            if (i >= testPanel.getWidth()) {
                ((Timer) timer).stop();
                i = 0;
            }
            testPanel.repaint();
        }
    }

    private Color fade(Color base) {
        return new Color(base.getRed(), base.getGreen(), base.getBlue(), 70);
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        super.paintBorder(c, g, x, y, width, height);
        Dimension size = c.getSize();

        GradientPaint upLeft = new GradientPaint((float) (size.getWidth() / 2), 5, color,
                (float) ((size.getWidth() / 2) + i), 5, fade(color), false);
        GradientPaint downLeft = new GradientPaint((float) (size.getWidth() / 2),
                (int) size.getHeight(), color, (float) ((size.getWidth() / 2) + i),
                (int) size.getHeight(), fade(color), false);
        GradientPaint upRigth = new GradientPaint((float) (size.getWidth() / 2) - i, 0,
                fade(color), (float) ((size.getWidth() / 2)), 0, color, false);
        GradientPaint downRigth = new GradientPaint((float) (size.getWidth() / 2) - i,
                (int) size.getHeight(), fade(color), (float) ((size.getWidth() / 2)),
                (int) size.getHeight(), color, false);
        Graphics2D g2 = (Graphics2D) g;
        g2.setPaint(upLeft);
        g2.fillRect((int) (size.getWidth() / 2), 0, i, 3);
        g2.setPaint(upRigth);
        g2.fillRect((int) (size.getWidth() / 2), 0, i, 3);
        g2.setPaint(downLeft);
        g2.fillRect((int) (size.getWidth() / 2) - i, (int) size.getHeight() - 5, i, 3);
        g2.setPaint(downRigth);
        g2.fillRect((int) (size.getWidth() / 2) - i, (int) size.getHeight() - 5, i, 3);
    }

    @Override
    public Insets getBorderInsets(Component c) {
        // return super.getBorderInsets(c);
        return new Insets(3, 0, 3, 0);
    }

    @Override
    public boolean isBorderOpaque() {
        return true;
    }

}