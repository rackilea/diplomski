public static void main(String[] args) {

        boolean suc1,suc2,suc3,suc4,suc5,suc6,suc7;

        JFrame f = new JFrame("Simulator");
        f.setSize(500, 400);
        f.setResizable(false);
        f.setLayout(null);
        f.setVisible(true);
        JButton b1 = new JButton("Start");
        b1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Button b1 was pressed");

            }
        });
        JButton b2 = new JButton("Clear");
        JButton b3 = new JButton("Find");
        JButton b4 = new JButton("Stop");
        b1.setBounds(20,335,80,25);
        b2.setBounds(110,335,80,25);
        b3.setBounds(200,335,80,25);
        b4.setBounds(395,335,80,25);
        f.add(b1);
        f.add(b2);
        f.add(b3);
        f.add(b4);
    }