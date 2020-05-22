class ColorRenderer extends DefaultTableCellRenderer
{
    @Override
    public Component getTableCellRendererComponent(
        JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
    {
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        if (isSelected)
            setBackground( table.getSelectionBackground() );
        else
        {
            setBackground( table.getBackground() );

            try
            {
                int number = Integer.parseInt( value.toString() );

                if (number > 24)
                    setBackground( Color.RED );
            }
            catch(Exception e) {}
        }

        return this;
    }
}