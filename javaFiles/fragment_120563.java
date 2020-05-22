timer = new Timer();
timer.schedule(new TimerTask() {
    private int i;          
    @Override
    public void run() {
        System.out.println("Hello");
        if (i%2 == 0)
            setRowColor(1, Color.RED);
        else 
            setRowColor(1, Color.GREEN);
        i++;
        table.revalidate();
        table.repaint();
    }
}, 0, 4000);