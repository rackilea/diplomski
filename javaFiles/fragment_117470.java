String[] header = {"NO","Name","Mark","Grade"};
DefaultTableModel model = new DefaultTableModel(header, 0);

for (int i = 0; i < MAX_STUDENTS; i++)
{
    ...

    model.addRow( new Object[]{ 1+i, Names[i], arrMark[i], grade} );
}

JTable table = new JTable(model );