list.addListSelectionListener(new ListSelectionListener() 
{

    public void valueChanged(ListSelectionEvent evt) 
    {
         // To avoid double value selected
         if (evt.getValueIsAdjusting())
            return;
         System.out.println("Selected: " + list.getSelectedValue());
    }

});