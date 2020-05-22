quest.addActionListener(new java.awt.event.ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton b = (JButton)e.getSource();
                    for(Component c : yourPanel.getComponents()){
                        if(c instanceof JButton && !c.equals(b)){
                            c.setEnabled(false);
                        }
                    }
                }
            });