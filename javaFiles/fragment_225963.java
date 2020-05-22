final Random generator = new Random(); 
    final String[] am = new String[25];
    final String[] ama = new String[25];

    for(int n = 0; n < 25; n++) {
        am[n] = "Sam " + n + " (Q)";
        ama[n] = "Sam " + n + " (A)";
    }

    JButton testButton = new JButton("Click This!");

    testButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent arg0) {             
            final int random_int = generator.nextInt(24) + 1;
            System.out.println(random_int);
            JOptionPane.showMessageDialog(null, am[random_int] + " " + ama[random_int]);
        }           
    });