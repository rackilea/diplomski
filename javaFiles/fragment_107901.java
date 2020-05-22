public void actionPerformed(ActionEvent ae)

{
    if(ae.getSource() instanceof JComboBox) {
            String str = (String)cb.getSelectedItem();
            if(str.equals("red"))
            p.setBackground(Color.red);

            if(str.equals("green"))
            p.setBackground(Color.green);

            if(str.equals("yellow"))
            p.setBackground(Color.yellow);
        }
          /////