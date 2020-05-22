SwingUtilities.invokeLater(new Runnable() {
        public void run() {
            //JOptionPane.showMessageDialog(null, new JScrollPane(getNewRenderedTable(getTable())));
              frame.setContentPane( new JScrollPane( getNewRenderedTable( getTable() ) );
              frame.setVisible(true);
        }
    });