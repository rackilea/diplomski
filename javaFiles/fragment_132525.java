stuffButton.addActionListener(new StuffListener(stuffList.get(i));

...

private class StuffListener implements ActionListener {
    private final Stuff myStuff;
    public StuffListener(Stuff stuff) {
        this.myStuff = stuff;
    }

    public void actionPerformed(ActionEvent e) {
        subtotalTextF.setText(String.valueOf(myStuff.getPrice()));
    }
}