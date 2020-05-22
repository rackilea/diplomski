Timer planTimer = new Timer(cycleTime * 1000, new ActionListener() {   
    @Override
    public void actionPerformed( ActionEvent e ) {
        planValue += 1;
    }
});
plainTimer.setRepeats(true);//Set repeatable.
planTimer.start();