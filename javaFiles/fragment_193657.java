final JButton okay = new JButton("Ok");
            okay.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane pane = getOptionPane((JComponent)e.getSource());
                    // set the value of the option pane
                    pane.setValue(JOptionPane.OK_OPTION);
                }
            });