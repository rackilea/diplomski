@Path("/obchod")
public class Obchod  implements ServletContextListener
{
    int size = 20;

    public void contextInitialized(ServletContextEvent event)
    {
        ServletContext sc = event.getServletContext();
        sc.setAttribute("Uzivatel", new Uzivatel(size));
        sc.setAttribute("Zbozi", new Zbozi(size));
        sc.setAttribute("Skladem", new Skladem(size));
        sc.setAttribute("ProdaneZbozi", new ProdaneZbozi(size));
        sc.setAttribute("KoupeneZbozi", new KoupeneZbozi(size));   
    }

    @POST
    @Path("/addUser")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addUser(@Context ServletContext context, String str)
    {
        Uzivatel u = (Uzivatel) context.getAttribute("Uzivatel");

        JSONObject obj = new JSONObject(str);   
        u.pridej(Integer.toString(u.maxID() + 1), obj.getString("Jmeno"), obj.getString("Prijmeni"), obj.getString("Datum_Narozeni"), obj.getString("Pozice"));
    }