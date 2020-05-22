GridLayout layout = new GridLayout(0,9);
        jPanel1.setLayout(layout);

        for(int row =0; row < 9; row++)
            for(int col=0; col<9;col++)
            {
                 JButton button = new JButton(); 
                if(col==0 && row==8)
                {    button.setEnabled(false);
                     button.setContentAreaFilled(false);
                }
                else if(col==0)
                    button.setText(""+(char)('A'+row));
                else if(row == 8)
                   button.setText(""+(char)('A'+col - 1)); 
                else if(col%2==0)
                    button.setBackground(Color.white);
                else     button.setBackground(Color.black);

                jPanel1.add(button);
            }