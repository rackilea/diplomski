while(rsFilm.next())
{
    title = rsFilm.getString("title");
    studio = rsFilm.getString("studio");
    rlsdate = rsFilm.getString("rlsdate");
    role = rsFilm.getString("role");
    oscar = rsFilm.getInt("oscar");

    out.println("<tr><td>&nbsp;</td><td>" + title + "</td>");
    out.println("<td>&nbsp;&nbsp;&nbsp;</td><td>(" + studio + "</a></td>"); 
    out.println("<td></td><td>" + rlsdate + ")</td>");  
    out.println("<td>&nbsp;&nbsp;</td><td>" + role + "</td>");
}