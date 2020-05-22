for (Component c : pane.getComponents()) {
    if (c instanceof JTextField) { 
       ((JTextField)c).setEnabled(false); 
       ((JTextField)c).setDisabledTextColor(Color.BLACK);
    }
}