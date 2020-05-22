public void actionPerformed(ActionEvent e)
    {

        if (test.equals(e.getActionCommand()))
        {
            menu = true;
            menu2();
        }
            if (test2.equals(e.getActionCommand()))
            {
                JOptionPane.showMessageDialog(null, "This is just a TEST!");
            }

    }