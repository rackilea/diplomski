@Override
     public void actionPerformed(ActionEvent e) {

        JPanel panTrk = new JPanel();
        panTrk.setBounds(201, 140, (screenSize.width - 400) / 3, 30);
        contentPane.add(panTrk);
        panTrk.setLayout(new GridLayout(1, 0, 0, 0));

        JButton btnTrkAtl = new JButton("Atleti\u010Dari");
        btnTrkAtl.setBackground(SystemColor.text);
        panTrk.add(btnTrkAtl);

        JButton btnTrkDisc = new JButton("Discipline");
        btnTrkDisc.setBackground(SystemColor.text);
        panTrk.add(btnTrkDisc);

        contentPane.revalidate();  // ***** added *****
        contentPane.repaint();     // ***** added *****
     }