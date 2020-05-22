class RegistrationPanel 
{
    private StartFrame startFrame;
    public RegistrationPanel(StartFrame startFrame) 
    {
        this.startFrame = startFrame;
    }

    // Called e.g. when a button was clicked on this panel
    void passBackInformationToStartFrame() 
    {
        startFrame.setInfo(this.getInfo());
    }
}


class StartFrame ...
{
    ...
    private void setCardLayout() 
    {       
        cardPanel.setLayout(cardLayout);

        // Remove: 
        //cardPanel.add(new RegistrationPanel(), "registration");

        // Add: 
        cardPanel.add(new RegistrationPanel(this), "registration");

        ....
    }
}