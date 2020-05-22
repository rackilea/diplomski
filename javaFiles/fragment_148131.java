public  class listenerCb implements ItemListener
{
    public void itemStateChanged(ItemEvent e)
    {
        if(cb.isSelected())
        {
            SwingUtilities.invokeLater(new Runnable()
            {
                public void run()
                {
                    JOptionPane.showMessageDialog(null,"Example");
                }
            });
        }
    }
}