for (int i = 0; i < names.length; i++)
{
    Vector row = new Vector(3);
    row.add( ...); // add the id
    row.add( names[i] );
    row.add( costs[i] );
    model.addRow( row );
}