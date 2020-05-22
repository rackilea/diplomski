public void actionPerformed(ActionEvent arg0)
{
    username = userText.getText();
    password = passText.getText();
    logname = logText.getText();
    // Here you should test if the input values are OK if it is KO do a   
    // return to prevent calling the following code
    synchronized (this) {
        // Release the waiting threads
        notifyAll();
    }
}