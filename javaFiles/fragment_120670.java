private int counter = 0;
private Timer timer;
...

timer = new javax.swing.Timer(500, new ActionListener() {

    @Override
    public void actionPerformed(ActionEvent arg0) {
        counter++;
        if(counter==10){
            timer.stop();
        }else{
            label.setText(counter + "");  
        }
    }
});
timer.setRepeats(true);
timer.start();