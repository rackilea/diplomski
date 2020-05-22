while (rs.next()) 
{
   listaValores = new ArrayList<String>();

   for(int i = 2; i <= ncolunas; i++)
   {
       listaValores.add(rs.getString(i));
   }

   tmValores.put(rs.getInt(1), listaValores);   
}