if (dialog.isVisible() 
        && e.getSource() == optionPane 
        && JOptionPane.VALUE_PROPERTY.equals(prop)
        && !optionPane.getValue().equals(JOptionPane.UNINITIALIZED_VALUE)){

    java.lang.System.out.println("Code Reached");
    optionPane.setValue(JOptionPane.UNINITIALIZED_VALUE);
}