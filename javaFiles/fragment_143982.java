@Override
    public void actionPerformed(ActionEvent e)
    {
        JButton btn = (JButton)e.getSource();

        // if desired, String cur = btn.getText() may be called to find the
        //  current setting; get and process if needed
        btn.setText(WHAT_EVER_TEXT);
    }