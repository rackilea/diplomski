private int currentIndex = 0;
private int delay = 2000;
...
Timer timer = new Timer(delay, new ActionListener(){
    public void actionPerformed(ActionEvent e) {
        if (current index is equal to array size) {
            ((Timer)e.getSource()).stop();
            MyDialog.this.dispose();
        } else {
            showImageByIndex(currentIndex);
            currentIndex++;
        }
    }
});