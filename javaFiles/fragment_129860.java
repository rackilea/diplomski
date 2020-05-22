// HERE
// I have a loop that have to be looping at every 500 ms
// and when something must be updated in the GUI:
SwingUtilities.invokeLater(new Runnable() {   
    public void run() {
        // update the GUI as fast as possible
    }
});