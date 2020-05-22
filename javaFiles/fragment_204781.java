public class MyRenderer extends DefaultListCellRenderer {

    @Override
    public Component getListCellRendererComponent(JList<? extends Chapter> list, Chapter value, int index, boolean isSelected, boolean cellHasFocus)
    {
       Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

       if (c instanceof Jlabel) { // it would work because DefaultListCellRenderer usually returns instance of JLabel
           ((JLabel)c).setText(value.myOwnCustomMethodThatReturnsString()); 
       }

       return c;
    }
}