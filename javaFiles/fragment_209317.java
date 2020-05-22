while (rs.next())
{
  Vector row = new Vector(columns);

  for (int i = 1; i <= columns; i++)
  {
      row.addElement( rs.getObject(i) );
  }

  row.addElement( your statice element here ); // extra column

  data.addElement( row );
}