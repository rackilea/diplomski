while (rs.next())
{
    Vector<Object> row = new Vector<Object>(columns);

    for (int i = 1; i <= columns; i++)
    {
        if (i == ?) // convert checked column
        {
            int value = rs.getInt(i);
            row.addElement( value == 0 ? Boolean.FALSE : Boolean.TRUE );
        }
        else
            row.addElement( rs.getObject(i) );
    }

    data.addElement( row );
}