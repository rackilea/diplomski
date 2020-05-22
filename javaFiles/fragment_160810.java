btn.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    // TODO Auto-generated method stub
                    int x;
                    x = Integer.parseInt(btn.getText());
                    x--;
                    btn.setText(Integer.toString(x));
                }
            });