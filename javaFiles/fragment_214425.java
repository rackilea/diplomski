final ActionListener timerDurationActionEvent = new ActionListener(){
    public void actionPerformed(ActionEvent evt){
        //Stops myTimer, so that Bluetooth Stops scanning every 10mins. 
        myTimer.stop();
        ((Timer)evt.getSource()).stop();
    }
};