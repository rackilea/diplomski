WindowListener exitListener = new WindowAdapter() {

        @Override
        public void windowClosing(WindowEvent e) {
            int confirm = JOptionPane.showOptionDialog(null, 
                  "Are You Sure to Close Application?", "Exit Confirmation", 
                  JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, 
                  null, null, null);
            if (confirm == JOptionPane.YES_OPTION) {
                Top-LevelContainer#setVisible(false);
                // clean-up everything 

                // on error display  JOptionPane with error mgs but from
                // another JVM instance, e.g.jar file, see add 3.)
                System.exit(1); //in some cases not works System.exit(0);
            }
     }