change61.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    cl1.setIcon(CL2);
                    lvrvr1.setIcon(LVRL);
                    dsw1.setIcon(LSIG);
                    dsy1.setIcon(CL1);
                    b1b.setIcon(LHC);
                    System.out.println("Button Pressed"); // THIS GETS PRINTED 3 TIMES TO CONSOLE INSTEAD OF ONCE
            }
        });