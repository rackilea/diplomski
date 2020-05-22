private MouseListener lastListener;
            // ...

            JComboBox cb = (JComboBox)e.getSource();

            if (cb.getSelectedItem().equals("Rectangle")) {         
            if (lastListener != null)
                contentPane.removeMouseListener(lastListener);
            lastListener = new MouseAdapter() {       //First mouseListener     
                // ...
            };
            contentPane.addMouseListener(lastListener);