class CalculatorWhichUsesAInterface extends JPanel {
     public CalculatorWhichUsesAInterface(){
        JPanel jPanelOne = new JPanel();
         jPanelOne.setLayout(new GridLayout(1, 1);


         jPanelOne.add(new JButton("x"));

         JPanel jPanelTwo = new JPanel(new BorderLayout());
         JTextField field = new JTextField();
         field.setText("2141987.01235");
         jPanelTwo.add(field, BorderLayout.NORTH);
         jPanelTwo.add(jPanelOne, BorderLayout.CENTER);
         add(jPanelTwo, BorderLayout.CENTER);
     }

    public static void main(String[] args){
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                CalculatorWhichUsesAInterface calc = new CalculatorWhichUsesAInterface();
                JFrame frame = new JFrame()
                frame.setTitle("Calculator");
                frame.add(calc);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}