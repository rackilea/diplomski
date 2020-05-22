this.extendingTimer = new Timer(0, new ActionListener()
{
    public void actionPerformed(ActionEvent e)
    {
       //assume sliding is vertical     
       int value = maximumHeight;
       //make sure the size will not be bigger then allowed maximum
       if(currentExtensionSize + extensionRate >= value)
       {
          currentExtensionSize = value;
          stopExtending();
       }
       else
          currentExtensionSize += extensionRate;
       setSize(new Dimension(maximumWidth, currentExtensionSize));
    }
});
extendingTimer.setInitialDelay(0);
extendingTimer.setDelay(100);
extendingTimer.setRepeats(true);