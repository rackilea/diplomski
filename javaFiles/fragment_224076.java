Action clearAction = new Action()
{
    @Override
    public void actionPerformed(ActionEvent e)
    {
        for (each row in the table)
            for (each column in the row)
                if (table.isCellSelected(...))
                   table.setValueAt("", ...);
    }
}