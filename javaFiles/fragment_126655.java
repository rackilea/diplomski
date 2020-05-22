Random generator = new Random();
final JFrame frame = new JFrame();
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
JPanel panel = new JPanel();

int num1 = generator.nextInt(101);
System.out.println("the random number is:" + num1);

JButton button1 = new JButton(String.format("Push Me! %d", num1));
frame.add(panel);
panel.add(button1);
frame.pack();
frame.setVisible(true);

button1.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent arg0) {
        int num1 = generator.nextInt(101);
        System.out.println("the random number is:" + num1);
        button1.setText(String.format("Push Me! %d", num1));
    }
});