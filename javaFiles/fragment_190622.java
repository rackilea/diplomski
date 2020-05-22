JButton buttons[] = {new JButton(), new JButton(), new JButton(),new JButton(), new JButton(), new JButton(),new JButton(), new JButton(), new JButton()};
    for(int i = 0; i < buttons.length; i++)
    {
        if( i < 5 )
            buttons[i].setToolTipText("Click here to check for the missing Flight 307");
        else
            buttons[i].setToolTipText("Is it here?");
    }