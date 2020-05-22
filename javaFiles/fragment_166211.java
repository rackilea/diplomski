public class MyColorChooser2 extends JPanel {

    private JFrame frame;
    private DrawPanel drawPanel;

    private JLabel redLabel, greenLabel, blueLabel;
    private JSlider redSlider, greenSlider, blueSlider;
    private JTextField redTextField, greenTextField, blueTextField;

    private JPanel redPanel, greenPanel, bluePanel, colorPanel, paintPanel;

    private int holdNbr1, holdNbr2, holdNbr3;
    private Color initialColor = Color.RED;

    public MyColorChooser2() {
        JFrame frame = new JFrame();
        frame.setTitle("Color Chooser");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Let DrawPanel choose the initial color. I don't care.
        drawPanel = new DrawPanel();
        // This way I control what is the initial color
        //drawPanel = new DrawPanel(initialColor);

        // set up labels
        redLabel = new JLabel("Red:");
        greenLabel = new JLabel("Green:");
        blueLabel = new JLabel("Blue:");

        // set up sliders and register their event handler:
        redSlider = new JSlider(SwingConstants.HORIZONTAL, 0, 255, initialColor.getRed());
        redSlider.setMajorTickSpacing(10); // create tick every 10
        redSlider.setPaintTicks(true); // paint ticks on slider

        greenSlider = new JSlider(SwingConstants.HORIZONTAL, 0, 255, initialColor.getGreen());
        greenSlider.setMajorTickSpacing(10); // create tick every 10
        greenSlider.setPaintTicks(true); // paint ticks on slider

        blueSlider = new JSlider(SwingConstants.HORIZONTAL, 0, 255, initialColor.getBlue());
        blueSlider.setMajorTickSpacing(10); // create tick every 10
        blueSlider.setPaintTicks(true); // paint ticks on slider

        // slider event handling:
        SliderHandler sliderHandler = new SliderHandler();
        redSlider.addChangeListener(sliderHandler);
        greenSlider.addChangeListener(sliderHandler);
        blueSlider.addChangeListener(sliderHandler);

        // set up textFields and register their event handler:
        redTextField = new JTextField(3);
        redTextField.setText("50"); // initialize
        redTextField.setEditable(false);
        redTextField.setText("" + redSlider.getValue());

        greenTextField = new JTextField(3);
        greenTextField.setText("100"); // initialize
        greenTextField.setEditable(false);
        greenTextField.setText("" + greenSlider.getValue());

        blueTextField = new JTextField(3);
        blueTextField.setText("200"); // initialize
        blueTextField.setEditable(false);
        blueTextField.setText("" + blueSlider.getValue());

        // build colorPanel:
        // build redPanel:
        redPanel = new JPanel();
        redPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        redPanel.add(redLabel);
        redPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        redPanel.add(redSlider);
        redPanel.add(redTextField);
        // build greenPanel:
        greenPanel = new JPanel();
        greenPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        greenPanel.add(greenLabel);
        greenPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        greenPanel.add(greenSlider);
        greenPanel.add(greenTextField);
        // build bluePanel:
        bluePanel = new JPanel();
        bluePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        bluePanel.add(blueLabel);
        bluePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        bluePanel.add(blueSlider);
        bluePanel.add(blueTextField);

        colorPanel = new JPanel();
        colorPanel.add(redPanel);
        colorPanel.add(greenPanel);
        colorPanel.add(bluePanel);

        frame.setLayout(new BorderLayout());
        frame.add(drawPanel, BorderLayout.CENTER);
        frame.add(colorPanel, BorderLayout.SOUTH);

        frame.setPreferredSize(new Dimension(900, 300));
        frame.setVisible(true);
        frame.pack();

    }

    private class DrawPanel extends JPanel {

        private Color color;
        private int red = 255, blue = 0, green = 0;

        @Override
        protected void paintComponent(Graphics g) {
            // I've removed the call to changeColor because it was creating
            // an infinite loop of revalidates and repaints.
            // Now, the paintComponent just finishes the job it was required to.
            super.paintComponent(g);
            g.setColor(color);
            g.fillRect(10, 10, 880, 200);
        }

        public DrawPanel() {
            this(Color.BLUE);
        }

        public DrawPanel(Color c) {
            color = c;
            red = color.getRed();
            green = color.getGreen();
            blue = color.getBlue();

            // I'm calling this first repaint here just to make
            // sure the panel is initiated the way we want with 
            // the given Color
            repaint();
        }

        void changeColor() {
            color = new Color(red, green, blue);
            // We just need to change the color and call this repaint here
            // so that the paintComponent can do its job
            repaint();
        }

        public void setRed(int r) {
            red = r;
            changeColor();
        }

        public void setBlue(int b) {
            blue = b;
            changeColor();
        }

        public void setGreen(int g) {
            green = g;
            changeColor();
        }
    }

    private class SliderHandler implements ChangeListener {

        @Override
        public void stateChanged(ChangeEvent e) {
            JSlider change = (JSlider) e.getSource();
            int value;

            // I've removed this line of code because you were
            // recreating the drawingPanel. That's not what you want.
            // You want to reuse the same panel.
            // DrawPanel draw = new DrawPanel();

            if (change == redSlider) {
                value = change.getValue();
                redTextField.setText(String.valueOf(value));
                drawPanel.setRed(value);
            } else if (change == greenSlider) {
                value = change.getValue();
                greenTextField.setText(String.valueOf(value));
                drawPanel.setGreen(value);
            } else if (change == blueSlider) {
                value = change.getValue();
                blueTextField.setText(String.valueOf(value));
                drawPanel.setBlue(value);
            }

            // You don't need to call those methods, because the
            // changeColor will be called by the settings 
            // of Red, Green            and Blue
            //       draw.changeColor();
            //       draw.repaint();

        }

    }

    public static void main(String args[]) {
        MyColorChooser2 color = new MyColorChooser2();
    }
}