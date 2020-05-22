public void flipEnabledOnAllButtons(boolean enabled, Container rootContainerToSearch)
{    
    for (Component c : rootContainerToSearch.getComponents())    
    {    
        if (c instanceof Container)    
        {    
            flipEnabledOnAllButtons(enabled, (Container)c);    
        }    

        if (c instanceof JButton)    
        {    
            c.setEnabled(enabled);    
        }      
    }
}