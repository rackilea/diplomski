public class ColorOptionsPanel extends JPanel {
    private JRadioButton [] colorButton= new JRadioButton[color.length];
    //....
    private class ColorListener implements ActionListener{
    // --------------------------------------------------------
    // Updates the background color of the panel based on
    // which radio button is selected.
    // --------------------------------------------------------
    public void actionPerformed (ActionEvent event){
        Object source = event.getSource();
        if (source==colorButton[i]){setBackground(colorButton[i]);}   
    }
}