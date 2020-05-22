try {
    Stringtoint = Integer.parseInt(userQuarts);
}  catch (NumberFormatException exe) {

    if(userQuarts.equals(""))
        JOptionPane.showMessageDialog(null, "Empty string not allowed", "Number Error", JOptionPane.ERROR_MESSAGE);
    else
        JOptionPane.showMessageDialog(null, "Only number is allowed", "Number Error", JOptionPane.ERROR_MESSAGE);

    return;
}