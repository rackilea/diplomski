while (rs.next())
{
    Vector<Object> row = new Vector<Object>(columns);

    for (int i = 1; i <= columns; i++)
    {
        row.addElement(rs.getObject(i) );
    }

    model.addRow( row )
}

JTable table = new JTable( model );