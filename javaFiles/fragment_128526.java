if(!table.getModel().getValueAt(row, 10).toString().equals("true"))
{
    setBackground(new Color(246,137,137));
}
else
    setBackground( table.getBackground() );