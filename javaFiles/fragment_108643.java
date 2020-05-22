DefaultTableModel model = new DefaultTableModel(
    new Object[]{"Name","Symbol","Atomic Number","Atomic Mass", "# of Valence Electrons"},
    0);
for (int x=0;x<data.length(); ++x)
{
    if (database[4].equalsIgnoreCase(valenceInput))                                                                                  //Search database for the number inputted by user
    {
        Object[] rows = {database[0],database[1],database[2],database[3],database[4]};
        model.addRow(rows);
    }
}

JTable table = new JTable(model);
JOptionPane.showMessageDialog(null, new JScrollPane(table));