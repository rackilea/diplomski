WindowListener myExitListener = new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                int confirmation = JOptionPane.showOptionDialog(jframe1, "Open frame2", "Open frame2", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
                if (confirmation == 0) {
                  //open jframe2 here
                }
            }
        };


jframe1.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
jframe1.addWindowListener(myExitListener);