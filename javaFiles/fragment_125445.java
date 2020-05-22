public void actionPerformed(ActionEvent e)
{
    DefaultTableModel model = (DefaultTableModel)table.getModel(); 

    model.addRow(new Object[]{"iphone", "73576"});
}