public class StartFrame extends JFrame implements ActionListener
{
    ...
    private RegistrationPanel registrationPanel

    private void setCardLayout()
    {       
        cardPanel.setLayout(cardLayout);

        // Remove: 
        //cardPanel.add(new RegistrationPanel(), "registration");

        // Add:
        registrationPanel = new RegistrationPanel();
        cardPanel.add(registrationPanel, "registration");
    }

    // Called e.g. when a button is clicked on this frame:
    void fetchInformationFromRegistrationPanel()
    {
        Info info = registrationPanel.getInfo();
        ...
    }