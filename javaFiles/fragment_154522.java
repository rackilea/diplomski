while ( rs.next()) {
            String soru = rs.getString("question");
            String birinci = rs.getString("first");
            String ikinci = rs.getString("second");
            String ucuncu = rs.getString("third");
            String dorduncu = rs.getString("forth");
            String dogru = rs.getString("right");

            // Calls to q1.setText, a1.setText, etc. moved from here.

            pnl1 = new JPanel();
            pnl1.setLayout(new GridLayout(1,1));

            q1 = new JLabel();
            pnl1.add(q1);
            pnlchoices1 = new JPanel();
            pnlchoices1.setLayout(new GridLayout(2,2));  
            a1 = new JRadioButton();
            a2 = new JRadioButton();
            a3 = new JRadioButton();
            a4 = new JRadioButton();

            pnlchoices1.add(a1);
            pnlchoices1.add(a2);
            pnlchoices1.add(a3);
            pnlchoices1.add(a4);

            container.add(pnl1);

            container.add(pnlchoices1);
            grp1 = new ButtonGroup();
            grp1.add(a1);
            grp1.add(a2);
            grp1.add(a3);
            grp1.add(a4);

            // Calls to q1.setText etc moved here.
            q1.setText(soru);
            a1.setText(birinci);
            a2.setText(ikinci);
            a3.setText(ucuncu);
            a4.setText(dorduncu);

            // Figure out which button is for the correct answer
            // and add it to our list of correct buttons.
            if (dogru.equals(birinci)) {
                correctButtons.add(a1);
            } else if (dogru.equals(ikinci)) {
                correctButtons.add(a2);
            } else if (dogru.equals(ucuncu)) {
                correctButtons.add(a3);
            } else if (dogru.equals(dorduncu)) {
                correctButtons.add(a4);
            } else {
                // If we get here, the correct answer is not one of the
                // options.  I don't know how you want to handle this.
            }
        }