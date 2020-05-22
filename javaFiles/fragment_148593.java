add(myCombo);
add(myButton);

SwingUtilities.invokeLater(new Runnable()
{
    public void run()
    {
        myCombo.showPopup();
        myCombo.hidePopup();
    }
});