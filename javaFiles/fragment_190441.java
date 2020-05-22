while(resultado.next())
{
 String name= resultado.getString("name");
 int id= resultado.getInt("id");
 out.println("<option value='"+id+"'>"+name+"</option>");
}