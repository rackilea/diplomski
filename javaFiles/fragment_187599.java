// wait for 1 second
Timer timer = new Timer(1000, new ActionListener() {

    @Override
    public void actionPerformed(ActionEvent arg0) {            
        // next call 
    }
});
timer.setRepeats(false);
timer.start()