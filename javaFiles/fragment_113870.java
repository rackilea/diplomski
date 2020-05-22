class CalculatorWhichUsesAInterface {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {

                JFrame frame = new JFrame();
                frame.setTitle("Calculator");
                frame.add(CalculatorBuilder.build());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }

    public static class CalculatorBuilder {

        public static JPanel build() {
            JPanel jPanelOne = new JPanel();
            jPanelOne.setLayout(new GridLayout(1, 1));

            jPanelOne.add(new JButton("x"));

            JPanel jPanelTwo = new JPanel(new BorderLayout());
            JTextField field = new JTextField();
            field.setText("2141987.01235");
            jPanelTwo.add(field, BorderLayout.NORTH);
            jPanelTwo.add(jPanelOne, BorderLayout.CENTER);
            return jPanelTwo;
        }

    }
}