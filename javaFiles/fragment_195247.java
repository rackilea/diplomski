for (each row);
{
    StringBuilder sb = new StringBuilder();

    for ( each column)
    {
        Object data = model.getValueAt(...);
        sb.append( data.toString() );
    }

    write the sb.toString() to the file
}