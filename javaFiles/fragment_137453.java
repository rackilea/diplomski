public class ToolBarWindow extends JFrame {

    private static Map<JRadioButton, Color> colors = new HashMap<>();
    private static Color currentColor = Color.BLACK;

    public static void main(String[] args) {

        ToolBarWindow frame = new ToolBarWindow();
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Colors");
        frame.setVisible(true);
    }

    public ToolBarWindow() {

        JPanel jpRadioButtons = new JPanel();
        jpRadioButtons.setLayout(new GridLayout(3, 1));

        // put the other colors
        JRadioButton red = new JRadioButton("red");
        JRadioButton black = new JRadioButton("black");
        JRadioButton magenta = new JRadioButton("magenta");

        red.addActionListener(new MyActionListener());
        black.addActionListener(new MyActionListener());
        magenta.addActionListener(new MyActionListener());

        jpRadioButtons.add(red);
        jpRadioButtons.add(black);
        jpRadioButtons.add(magenta);

        colors.put(red, Color.RED);
        colors.put(black, Color.BLACK);
        colors.put(magenta, Color.MAGENTA);

        add(jpRadioButtons, BorderLayout.WEST);

        ButtonGroup bg = new ButtonGroup();
        bg.add(red);
        bg.add(black);
        bg.add(magenta);
    }

    Color getCurrentColor() {

        return currentColor;
    }

    private class MyActionListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            currentColor = colors.get(e.getSource());
        }
    }
}