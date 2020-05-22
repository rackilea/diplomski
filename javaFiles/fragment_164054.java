public Component prepareRenderer(TableCellRenderer renderer, int row, int column)
{
Component c = super.prepareRenderer(renderer, row, column);
if(column==0){
    c.setBackground(new java.awt.Color(223, 223, 223));
    c.setForeground(new Color(121, 63, 63));
    c.setFont(new java.awt.Font("Tahoma", java.awt.Font.BOLD, 12));
}else{
    setBackground(new java.awt.Color(235, 235, 235));//c.setBackground(..) was the problem
    c.setFont(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 12));

}
return c;
}