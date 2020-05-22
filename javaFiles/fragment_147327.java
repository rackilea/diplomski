public void setPanelColor(Container parent)
{
    for(Component c : parent.getComponents())
    {
        if(c instanceof Container)
        {
            if(c instanceof JPanel)
            {
                c.setBackground(panelColor);
            }

            setPanelColor((Container)c);
        }
    }
}