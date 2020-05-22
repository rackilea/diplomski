public Seats[][] seats = new Seats[4][10]; 

public Book_GUI() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);

    int left = 3;
    int middle = 3;
    int right = 4;

    String[] singleRowAll = new String[left + middle + right];

    for (int i = 1; i < singleRowAll.length; i++) {
        singleRowAll[i] = "";
    }
    singleRowAll[0] = "Window";
    singleRowAll[left - 1] = "Aisle";
    singleRowAll[left] = "Aisle";
    singleRowAll[left + middle - 1] = "Aisle";
    singleRowAll[left + middle] = "Aisle";
    singleRowAll[left + middle + right - 1] = "Window";

    // eco = new EconomyClass(4,5,3,3,4);

            //Delete this line:
    //final Seats[][] seats = new Seats[4][5];

    for(int i = 0; i < 4; i++) {
        for(int j = 0; j < 5; j++) {
            seats[i][j] = new Seats();
        }
    }

    for (int i = 0; i < 4; i++) {
        char c = 'A';
        for (int j = 0; j < 10; j++) {
            final int x = i;
            final int z = j;
            final JButton btnBookFlight = new JButton(" " + (i + 1) + c++
                    + " " + singleRowAll[j]);
            btnBookFlight.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    if (seats[x][z].isBooked()) {
                        btnBookFlight.setBackground(Color.GREEN);
                    }

                    seats[x][z].setBooked(true);

                    // JButton button = (JButton)arg0.getSource();
                    // button.setBackground(Color.RED);
                    // btnBookFlight.setBackground(Color.RED);
                    btnBookFlight.setOpaque(true);
                }
            });
            contentPane.add(btnBookFlight);
        }
    }

    contentPane.setLayout(new GridLayout(4, 10));
    pack();
}