public class ShowColors {

    class Rectangle extends JComponent implements ChangeListener {
        private JSlider slider; 
        private Color color;

        public Rectangle(JSlider slider, Color color) {
            this.slider = slider;
            this.color = color;
            this.setPreferredSize(new Dimension(250, 250));
            slider.addChangeListener(this);
        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            int value = slider.getValue();
            g.setColor(color);
            g.fillRect(10,10,100,value);

        }

        @Override
        public void stateChanged(ChangeEvent arg0) {
            this.repaint();
        }
    }

    public ShowColors() {
        JFrame frame = new JFrame();

        JPanel main = new JPanel(new BorderLayout());
        main.setSize(2000, 1000);
        frame.setContentPane(main);

        JPanel jp1 = new JPanel(new GridLayout(0, 1));
        JPanel jp2 = new JPanel(new GridLayout(2, 3));

        jp1.setPreferredSize(new Dimension(90, 800));
        jp2.setPreferredSize(new Dimension(1000, 150));

        JRadioButton rb1 = new JRadioButton("Decimal", true);
        JRadioButton rb2 = new JRadioButton("Binary");
        JRadioButton rb3 = new JRadioButton("Hex");
        JRadioButton rb4 = new JRadioButton("Octal");
        JButton jb1 = new JButton("RESET");

        ButtonGroup group = new ButtonGroup();
        group.add(rb1);
        group.add(rb2);
        group.add(rb3);
        group.add(rb4);

        JSlider jRed = buildSlider();
        JSlider jGreen = buildSlider();
        JSlider jBlue = buildSlider();

        JLabel labelR = new JLabel("Red", JLabel.CENTER);
        JLabel labelG = new JLabel("Green", JLabel.CENTER);
        JLabel lableB = new JLabel("Blue", JLabel.CENTER);

        jp1.add(rb1);
        jp1.add(rb2);
        jp1.add(rb3);
        jp1.add(rb4);
        jp1.add(jb1);

        jp2.add(labelR);
        jp2.add(labelG);
        jp2.add(lableB);
        jp2.add(jRed);
        jp2.add(jGreen);
        jp2.add(jBlue);

        JPanel canvas = new JPanel();
        canvas.setLayout(new FlowLayout());
        canvas.setPreferredSize(new Dimension(800, 600));
        canvas.add(new Rectangle(jRed, Color.RED));
        canvas.add(new Rectangle(jGreen, Color.GREEN));
        canvas.add(new Rectangle(jBlue, Color.BLUE));

        main.add(jp1, BorderLayout.WEST);
        main.add(jp2, BorderLayout.SOUTH);
        main.add(canvas, BorderLayout.EAST);

        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private static JSlider buildSlider() {
        JSlider slider = new JSlider(0, 255);
        slider.setPaintLabels(true);
        slider.setPaintTicks(true);
        slider.setMinorTickSpacing(5);
        slider.setMajorTickSpacing(50);
        slider.setValue(50);
        return slider;
    }

    public static void main(String args[]) {
        new ShowColors();
    }

}