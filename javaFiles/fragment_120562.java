timer = new Timer(4000, new ActionListener() {
    private int i;
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("hello");
        if (i%2 == 0)
            setRowColor(1, Color.RED);
        else 
            setRowColor(1, Color.GREEN);
        i++;
        table.revalidate();
        table.repaint();    
    }
});
timer.start();