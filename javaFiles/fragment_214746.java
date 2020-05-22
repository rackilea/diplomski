private void walkjButtonActionPerformed(java.awt.event.ActionEvent evt) {                                            
    if(!running){
        running = true;
        timer = new Timer(40, walk);
        timer.start();
    }
    else{
        timer.stop();
        running = false;
    }
}