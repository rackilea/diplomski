Timer timer  = new Timer(40, new ActionListener(){
    @Override
    public void actionPerformed(ActionEvent e) {
        if (sortingIsDone()) {
            ((Timer)e.getSource()).stop();
        } else {
            sortOnlyOneItem();
        }
        repaint();
    }
});