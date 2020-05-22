checkBox.addItemListener( new ItemListener()
{
    public void itemStateChanged(java.awt.event.ItemEvent evt)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                if(evt.getStateChange() == ItemEvent.SELECTED)
                {
                    JOptionPane.showMessageDialog(null, "Check box 1 selected");
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Check box 1 deselected");
                }
            }
        });
    }
});