Timer timer = new Timer(delay, new ActionListener()(
    @Override
    public void actionPerformed(ActionEvent e) {
        if (count == 0) {
            ((Timer)e.getSource()).stop();
        } else {
            //make a change to your label
            count--;
        }
    }
));