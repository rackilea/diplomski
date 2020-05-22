int counter = 0;
int[] userNumbers = new int[3];

public lotteryGUI() {
    initComponents();

    JButton number1 = new JButton("1");
    JButton number2 = new JButton("2"); 

    number1.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            userNumbers[counter] = 1;
            counter = counter + 1;
            if (counter == 3)
                // disable all buttons and display result maybe?
        }
    }

    // ... the rest 27 buttons maybe?
}