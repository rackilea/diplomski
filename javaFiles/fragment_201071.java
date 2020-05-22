Input i = new Input();
         add.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    InputFrame s = new InputFrame();                    
                    s.add(i.labelPanel);
                    s.setVisible(true);
                }