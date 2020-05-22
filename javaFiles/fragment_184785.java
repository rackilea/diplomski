private void addActionListener(ActionListener listener,
          JComponent... possibleActionListenerComponents)
{
    for(JComponent c : possibleActionListenerComponents)
        if (c instanceof AbstractButton)
            ((AbstractButton)c).addActionListener(listener);
        else if (c instanceof JComboBox)
            ((JComboBox)c).addActionListener(listener);
}